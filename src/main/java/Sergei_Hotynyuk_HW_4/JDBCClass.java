package Sergei_Hotynyuk_HW_4;

import java.sql.*;

public class JDBCClass {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "123456";

    // private static ResultSet rs;

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

    public void transaction(String transaction) throws SQLException {
        try {
            connection = getDBConnection();
            statement = connection.createStatement();
            statement.executeUpdate(transaction);
            System.out.println("Transaction successful");
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

    public void transaction2(int user_id, int operation, String currency) throws SQLException {

        // String select = "SELECT * FROM accounts WHERE accounts.user_id=? AND accounts.currency~*?";
        String update = "UPDATE accounts SET balance=? WHERE accounts.account_id=? AND accounts.currency~*?";

        String transaction = "INSERT INTO TRANSACTIONS(TRANSACTION_ID, ACCOUNT_ID, AMOUNT) VALUES(?, ?, ?)";
        int account_id = 0;
        int tr_id = 0;
        int balance = 0;

        try {
            connection = getDBConnection();
            statement = connection.createStatement();
            connection.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts ");

            while (resultSet.next()) {
                account_id = resultSet.getInt(1);
                balance = resultSet.getInt(3);

            }
            balance += operation;
            PreparedStatement pstmt = connection.prepareStatement(update);

            pstmt.setInt(1, balance);
            pstmt.setInt(2, user_id);
            pstmt.setString(3, currency);

            pstmt.executeUpdate();
            pstmt = connection.prepareStatement(transaction);

            pstmt.setInt(1, (int) (Math.random() * 1000));
            pstmt.setInt(2, account_id);
            pstmt.setInt(3, operation);

            pstmt.executeUpdate();
            connection.commit();

            System.out.println("Transaction successful");
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
}



