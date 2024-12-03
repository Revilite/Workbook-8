import org.apache.commons.dbcp2.*;

import java.sql.*;
import java.util.Scanner;


public class SqlApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BasicDataSource dataSource;
        dataSource = new BasicDataSource();


        String url = "jdbc:mysql://localhost:3306/dealership";

        dataSource.setUsername("root");
        dataSource.setPassword("yearup");
        dataSource.setUrl(url);


        System.out.print("Enter the make you are looking for: ");
        String makeToLookFor = scan.nextLine();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO vehicles VALUES (?)");
            connection.getMetaData();
//            Statement statement = connection.createStatement();
//            statement.executeQuery("SELECT * FROM vehicles WHERE make = '" + makeToLookFor + "';");
//            ResultSet resultSet = statement.getResultSet();
//            while (resultSet.next()) {
//                String make = resultSet.getString("MAKE");
//                String model = resultSet.getString("MODEL");
//                double price = resultSet.getDouble("PRICE");
//                System.out.printf("%-15s, %-10s   $%-13.2f %n", make, model, price);
//
//a
//            }

            insertStatement.setString(1, makeToLookFor);
            insertStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            dataSource.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
// 