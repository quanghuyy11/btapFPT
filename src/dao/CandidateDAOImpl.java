package dao;

import entity.Candidate;
import exception.BirthDayException;
import exception.EmailException;
import util.CheckRegex;
import util.DBUtils;
import util.SQLCommand;

import java.sql.*;
import java.util.Scanner;

public class CandidateDAOImpl implements CandidateDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private CheckRegex checkRegex;

    public CandidateDAOImpl(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet, CheckRegex checkRegex) {
        this.connection = connection;
        this.preparedStatement = preparedStatement;
        this.resultSet = resultSet;
        this.checkRegex = checkRegex;
    }

    @Override
    public void addDetailInfo(Candidate candidate) throws SQLException {
        Scanner sc = new Scanner(System.in);
        switch (candidate.getCandidateType()) {
            case "0" -> {
                preparedStatement = connection.prepareCall(SQLCommand.EXPERIENCE_QUERY_ADD);
                int expYear = sc.nextInt();
                String proSkill = sc.nextLine();
                preparedStatement.setInt(1, candidate.getCandidateID());
                preparedStatement.setInt(2, expYear);
                preparedStatement.setString(3, proSkill);
            }
            case "1" -> {
                preparedStatement = connection.prepareCall(SQLCommand.FRESHER_QUERY_ADD);
                Date graduationDate = Date.valueOf(sc.nextLine());
                String graduationRank = sc.nextLine();
                String education = sc.nextLine();
                preparedStatement.setInt(1, candidate.getCandidateID());
                preparedStatement.setDate(2, graduationDate);
                preparedStatement.setString(3, graduationRank);
                preparedStatement.setString(4, education);
            }
            case "2" -> {
                preparedStatement = connection.prepareCall(SQLCommand.INTERN_QUERY_ADD);
                String majors = sc.nextLine();
                String semester = sc.nextLine();
                String universityName = sc.nextLine();
                preparedStatement.setInt(1, candidate.getCandidateID());
                preparedStatement.setString(2, majors);
                preparedStatement.setString(3, semester);
                preparedStatement.setString(4, universityName);
            }
        }
    }

    @Override
    public void add(Candidate candidate) {
//        boolean check = false;
        if (checkRegex.checkBirthDay(candidate.getBirthDay()))
            throw new BirthDayException("Nhap sai birth day!!");
        if (checkRegex.checkEmail(candidate.getEmail()))
            throw new  EmailException("Nhap sai email!!!");
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareCall(SQLCommand.CANDIDATE_QUERY_ADD);

            preparedStatement.setInt(1, candidate.getCandidateID());
            preparedStatement.setString(2, candidate.getFullName());
            preparedStatement.setDate(3, Date.valueOf(candidate.getBirthDay()));
            preparedStatement.setString(4, candidate.getPhone());
            preparedStatement.setString(5, candidate.getEmail());
            preparedStatement.setString(6, candidate.getCandidateType());
            preparedStatement.execute();
            addDetailInfo(candidate);

        } catch (SQLException e) {
            throw new RuntimeException("The system has encountered an unexpected problem, sincerely sorry !!!");
        } finally {
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
//        return check;
    }

//    @Override
//    public int update(Candidate candidate) {
//        return 0;
//    }
//
//    @Override
//    public void delete(Candidate candidate) {
//
//    }
//
//    @Override
//    public List<Candidate> findAll() {
//        return null;
//    }
//
//    @Override
//    public Candidate findById(Candidate candidate) {
//        return null;
//    }
//
//    @Override
//    public List<Candidate> findByCondition(String condition) {
//        return null;
//    }
}
