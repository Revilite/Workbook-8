package com.pluralsight;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    }

    public static void firstExample() throws ClassNotFoundException, SQLException {
        //Force loads the driver class into memory
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Creates connection from mysql, does not need mysql workbench running
        Connection connection;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sakila",
                //username and password to access db server
                "root",
                "yearup"
        );

        Statement statement = connection.createStatement();
        String query = "SELECT first_name FROM actor " + "WHERE first_name LIKE 'd%'";
        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            String city = results.getString("first_name");
            System.out.println(city);
        }

        connection.close();

    }

    public static void secondExample() throws ClassNotFoundException, SQLException {
        Scanner scan = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection db = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dealership",
                "root",
                "yearup"
        );

        System.out.println("What kind of car do you want?");
        String car = scan.nextLine();

        String[] makeModel = car.split(" ");
        String query = "SELECT * FROM vehicle" + "WHERE make LIKE '?'";

        PreparedStatement statement = db.prepareStatement(query);

        statement.setString(1, makeModel[0]);

        ResultSet results = statement.executeQuery(statement);


    }
}
