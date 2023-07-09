package dao;

import util.DBUtils;
import util.SQLCommand;

import java.sql.*;
import java.util.Scanner;

public class CertificateDAOImpl implements CertificateDAO {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private Scanner sc = new Scanner(System.in);
    @Override
    public boolean addCertificate() {
        boolean check = false;
        try {
            connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLCommand.CERTIFICATE_QUERY_ADD);

            System.out.print("Nhap ID ung cu vien de nhap bang cap: ");
            int candidateID = Integer.parseInt(sc.nextLine());

            System.out.print("Nhap ID bang cap: ");
            int certificateID = Integer.parseInt(sc.nextLine());

            System.out.print("Nhap ten bang cap: ");
            String certificateName = sc.nextLine();

            System.out.print("Nhap rank bang cap: ");
            String certificateRank = sc.nextLine();

            System.out.print("Nhap ngay nhan bang cap: ");
            String certificateDate = sc.nextLine();
//            infoLogger.info("Executing query: " + query);

            statement.setLong(1, certificateID);
            statement.setLong(2, candidateID);
            statement.setString(3, certificateName);
            statement.setString(4, certificateRank);
            statement.setDate(5, Date.valueOf(certificateDate));

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                check = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
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
}
