package Sergei_Hotynyuk_HW_4;

import java.math.BigDecimal;
import java.sql.*;

public class JDBCClass {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "123456";


    Connection connection = null;
    Statement statement = null;


    public static Connection getDBConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver is not found");
            e.printStackTrace();
        }
        //System.out.println("Connection successfuly");

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return connection;
    }

//    public void createDB(String createDataBase) throws SQLException {
//        try {
//            connection = getDBConnection();
//            statement = connection.createStatement();
//
//// sql запрос
//            statement.execute(createDataBase);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        }
//    }

    public void createDbUserTable(String createTableSQL) throws SQLException {
        try {
            connection = getDBConnection();
            statement = connection.createStatement();

            // sql запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"users\" is creared!");
            System.out.println("Table \"accounts\" is creared!");
            System.out.println("Table \"transactions\" is creared!");

            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }


    public void addDataInTable(String dataInfo) throws SQLException {
        //  String createAccount = "INSERT INTO ACCOUNTS(ACCOUNT_ID ,USER_ID, BALANCE, CURRENCY) VALUES('1', '1','5000', 'US')";
        try {
            connection = getDBConnection();
            statement = connection.createStatement();
            statement.executeUpdate(dataInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }


    public void transaction2(int user_id, double operation, String currency) throws SQLException {

        String select = "SELECT * FROM accounts WHERE accounts.user_id=? AND accounts.currency~*?";
        String update = "UPDATE accounts SET balance=? WHERE accounts.account_id=? AND accounts.currency~*?";
        String transaction = "INSERT INTO TRANSACTIONS(TRANSACTION_ID, ACCOUNT_ID, AMOUNT) VALUES(?, ?, ?)";


        int account_id = 0;
        double balance = 0;

        try {
            connection = getDBConnection();
            statement = connection.createStatement();

            PreparedStatement ps = connection.prepareStatement(select);
            connection.setAutoCommit(false);

            ps.setInt(1, user_id);
            ps.setString(2, currency);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                account_id = resultSet.getInt(1);
                balance = Double.parseDouble(String.valueOf(resultSet.getBigDecimal(3)));

            }
            balance += operation;

            PreparedStatement pstmt = connection.prepareStatement(update);

            pstmt.setBigDecimal(1, BigDecimal.valueOf(balance));
            pstmt.setInt(2, account_id);
            pstmt.setString(3, currency);

            pstmt.executeUpdate();

            pstmt = connection.prepareStatement(transaction);

            pstmt.setInt(1, (int) (Math.random() * 1000));
            pstmt.setInt(2, account_id);
            pstmt.setBigDecimal(3, BigDecimal.valueOf(operation));

            pstmt.executeUpdate();

            connection.commit();

            System.out.println("Transaction successful");
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}



