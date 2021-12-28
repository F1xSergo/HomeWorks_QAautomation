package Sergei_Hotynyuk_HW_4;
//Написать sql скрипт для создания базы данных со следующей структурой:
//Написать программу на Java, предоставляющую следующую функциональность:
//Регистрацию нового пользователя
//Добавление аккаунта новому пользователю
//Пополнение существующего аккаунта
//Снятие средств с существующего аккаунта.
//Ограничения:
//Каждый пользователь может иметь сколько угодно аккаунтов в разных валютах
//Пользователь может иметь только 1 аккаунт в конкретной валюте
//Размер транзакции не может превышать 100’000’000
//Баланс аккаунта не может быть отрицательным или превышать 2’000’000’000
//Поле адрес является необязательном к заполнению при регистрации
//Дробная часть чисел ограничена 3 знаками.
//Дополнительные условия:
//Необходимо использовать JDBC
//Необходимо использовать драйвер для PostgreSQL
//Для помощи в написании и проверки, что действительно происходит в базе, рекомендуется использовать pgAdmin
//В таблицу транзакций пополнения записываются как положительные числа, снятия как отрицательные. При этом пользователь в обоих случаях вводит положительные числа.

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        JDBCClass jdbcClass = new JDBCClass();
        try {
//            //создаем базу данных
//            jdbcClass.createDB("CREATE DATABASE postgres");
            //Создаем 3 таблицы
            jdbcClass.createDbUserTable(
                    "CREATE TABLE USERS(" +
                            "USER_ID INTEGER  UNIQUE, " +
                            "NAME VARCHAR(50) NOT NULL, " +
                            "ADDRESS VARCHAR(255), " +
                            "PRIMARY KEY(USER_ID)" +
                            ");"

                            + "CREATE TABLE ACCOUNTS(" +
                            "ACCOUNT_ID INTEGER  UNIQUE, " +
                            "USER_ID INTEGER NOT NULL, " +
                            "BALANCE DECIMAL(10,3) CHECK(BALANCE >= 0 AND BALANCE <= 1000000000) NOT NULL, " +
                            "CURRENCY VARCHAR(15) NOT NULL, " +
                            "PRIMARY KEY(ACCOUNT_ID), " +
                            "FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)" +
                            "); "

                            + "CREATE TABLE TRANSACTIONS(" +
                            "TRANSACTION_ID INTEGER  NOT NULL, " +
                            "ACCOUNT_ID INTEGER NOT NULL, " +
                            "AMOUNT DECIMAL(10,3) CHECK(AMOUNT >= 0 AND AMOUNT <= 1000000000) NOT NULL, " +
                            "PRIMARY KEY(TRANSACTION_ID), " +
                            "FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNTS(ACCOUNT_ID)" +
                            ")");

            //добавляем юзера
            jdbcClass.addDataInTable("INSERT INTO USERS(USER_ID, NAME) VALUES('1', 'Bob')");
            jdbcClass.addDataInTable("INSERT INTO USERS(USER_ID, NAME, ADDRESS) VALUES('2', 'Том', 'Minsk')");
            System.out.println("Пользователи добавлены");

            //добавлям данные аккаунта
            jdbcClass.addDataInTable("INSERT INTO ACCOUNTS(ACCOUNT_ID ,USER_ID, BALANCE, CURRENCY) VALUES('1', '1','5000', 'US')");
            jdbcClass.addDataInTable("INSERT INTO ACCOUNTS(ACCOUNT_ID ,USER_ID, BALANCE, CURRENCY) VALUES('3', '1','5000', 'EUR')");
            jdbcClass.addDataInTable("INSERT INTO ACCOUNTS(ACCOUNT_ID ,USER_ID, BALANCE, CURRENCY) VALUES('2', '2','4000', 'US')");
            System.out.println("Данные в аккаунты записаны");

            //делаем транзакцию
//            jdbcClass.transaction("UPDATE ACCOUNTS SET BALANCE = BALANCE - 3000 WHERE ACCOUNT_ID = 1");
//            jdbcClass.transaction("UPDATE ACCOUNTS SET BALANCE = BALANCE + 1000 WHERE ACCOUNT_ID = 2");
//            System.out.println("Транзакции сделаны");

            // ResultSet в транзакциях реализовать
            jdbcClass.transaction2(1, 2000.24,"US");
            jdbcClass.transaction2(2, 5000.24,"US");
            System.out.println("эта херь заработала");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
