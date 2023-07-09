package dao;

import entity.Candidate;
import exception.BirthDayException;
import exception.EmailException;
import util.CheckRegex;
import util.DBUtils;
import util.SQLCommand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateDAOImpl implements CandidateDAO {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Scanner sc = new Scanner(System.in);

    @Override
    public Candidate inputCandidate() {
        Candidate candidate = new Candidate();
        try {
            System.out.println("Nhap ID cua candidate:");
            int candidateID = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhap name cua candidate:");
            String fullName = sc.nextLine();
            System.out.println("Nhap birthday cua candidate:");
            String birthDay = sc.nextLine();
            System.out.println("Nhap phone cua candidate:");
            String phone = sc.nextLine();
            System.out.println("Nhap email cua candidate:");
            String email = sc.nextLine();
            System.out.println("Nhap type cua candidate:");
            int candidateType = sc.nextInt();
            candidate.setCandidateID(candidateID);
            candidate.setFullName(fullName);
            candidate.setBirthDay(Date.valueOf(birthDay));
            candidate.setPhone(phone);
            candidate.setEmail(email);
            candidate.setCandidateType(candidateType);
        } catch (Exception e){
            Candidate.candidateCount -= 1;
            throw new RuntimeException("The system has encountered an unexpected problem, sincerely sorry !!!");
        }
        return candidate;
    }

    @Override
    public void addDetailInfo(Candidate candidate) throws SQLException {
        switch (candidate.getCandidateType()) {
            case 0 -> {
                preparedStatement = connection.prepareStatement(SQLCommand.EXPERIENCE_QUERY_ADD);
                System.out.println("Nhap so nam kinh nghiem:");
                int expYear = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhap ki nang chuyen mon:");
                String proSkill = sc.nextLine();
                preparedStatement.setInt(1, candidate.getCandidateID());
                preparedStatement.setInt(2, expYear);
                preparedStatement.setString(3, proSkill);
            }
            case 1 -> {
                preparedStatement = connection.prepareStatement(SQLCommand.FRESHER_QUERY_ADD);
                sc.nextLine();
                System.out.println("Nhap ngay tot nghiep:");
                String graduationDate = sc.nextLine();
                System.out.println("Nhap xep loai tot nghiep:");
                String graduationRank = sc.nextLine();
                System.out.println("Nhap truong tot nghiep:");
                String education = sc.nextLine();
                preparedStatement.setInt(1, candidate.getCandidateID());
                preparedStatement.setDate(2, Date.valueOf(graduationDate));
                preparedStatement.setString(3, graduationRank);
                preparedStatement.setString(4, education);
            }
            case 2 -> {
                preparedStatement = connection.prepareStatement(SQLCommand.INTERN_QUERY_ADD);
                sc.nextLine();
                System.out.println("Nhap chuyen nganh:");
                String majors = sc.nextLine();
                System.out.println("Nhap hoc ki dang hoc:");
                String semester = sc.nextLine();
                System.out.println("Nhap truong dang hoc:");
                String universityName = sc.nextLine();
                preparedStatement.setInt(1, candidate.getCandidateID());
                preparedStatement.setString(2, majors);
                preparedStatement.setString(3, semester);
                preparedStatement.setString(4, universityName);
            }
        }
        preparedStatement.execute();
    }

    @Override
    public boolean addCandidateUsePrepared() {
        Candidate candidate = inputCandidate();
        boolean check;
        CheckRegex checkRegex = new CheckRegex();
        if (!checkRegex.checkBirthDay(String.valueOf(candidate.getBirthDay())))
            throw new BirthDayException("Nhap sai birth day!!");
        if (!checkRegex.checkEmail(candidate.getEmail()))
            throw new  EmailException("Nhap sai email!!!");
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.CANDIDATE_QUERY_ADD);

            preparedStatement.setInt(1, candidate.getCandidateID());
            preparedStatement.setString(2, candidate.getFullName());
            preparedStatement.setDate(3, Date.valueOf(candidate.getBirthDay()));
            preparedStatement.setString(4, candidate.getPhone());
            preparedStatement.setString(5, candidate.getEmail());
            preparedStatement.setInt(6, candidate.getCandidateType());
            int rowaffected = preparedStatement.executeUpdate();

            if (rowaffected == 1) {
                addDetailInfo(candidate);
            }
            System.out.println("Ban da them vao " + Candidate.candidateCount + " candidate!");
            check = true;
        } catch (SQLException e) {
            throw new RuntimeException("The system has encountered an unexpected problem, sincerely sorry !!!");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null && sc != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    //Day 4,5 muc 4
    public void getFullName() {
        try {
            connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
//            infoLogger.info("Executing query: " + sql);
            ResultSet rs = statement.executeQuery(SQLCommand.CANDIDATE_FIND_ALL);

            StringBuffer fullNameBuffer = new StringBuffer();
            while(rs.next()){
                fullNameBuffer.append(rs.getString("FullName"));
                fullNameBuffer.append(",");
            }

            if (fullNameBuffer.length() > 2) {
                fullNameBuffer.setLength(fullNameBuffer.length() - 1);
            }

            String fullNameString = fullNameBuffer.toString();
            System.out.println(fullNameString);

        } catch (Exception ex) {
            ex.printStackTrace();
//            infoLogger.error("Exception occurred ",ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null && sc != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<Candidate> getAllCandidate(){
        List<Candidate> candidates = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.CANDIDATE_FIND_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Candidate candidate = new Candidate();

                candidate.setCandidateID(resultSet.getInt("candidateID"));
//                candidate.setFullName(resultSet.getString("customer_name"));
//                candidate.setBirthDay(resultSet.getString("created_date"));
//                candidate.setEmail(resultSet.getInt("discount"));
//                candidate.setPhone(resultSet.getDouble("total_price"));
//                candidate.setCandidateType(resultSet.getDouble("total_price"));
                candidates.add(candidate);
            }
        }
        catch (SQLException e){
            throw new RuntimeException("The system has encountered an unexpected problem, sincerely sorry !!!");
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return candidates;
    }
}
