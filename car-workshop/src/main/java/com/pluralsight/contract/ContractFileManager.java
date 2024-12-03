package com.pluralsight.contract;

import com.pluralsight.cars.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {
    public void saveToFile(String line) {
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./src/main/resources/WorkshopFiles/contract.csv", true));
            buffWrite.write(line);
            buffWrite.close();
        } catch (IOException e) {
            System.out.println("Could not save into file :(");
        }
    }

    public ArrayList<Contract> readFromFile() {

        ArrayList<Contract> contracts = new ArrayList<>();
        try {
            BufferedReader buffRead = new BufferedReader(new FileReader("./src/main/resources/WorkshopFiles/contract.csv"));
            String input;
            try {
                while ((input = buffRead.readLine()) != null) {
                    String[] segments = input.split("[|]");

                    //Length of lease
                    if (segments.length == 16) {
                        String date = segments[1];
                        String customerName = segments[2];
                        String customerEmail = segments[3];
                        String vin = segments[4];
                        String vehicleYear = segments[5];
                        String make = segments[6];
                        String model = segments[7];
                        String vehicleType = segments[8];
                        String color = segments[9];
                        String odometer = segments[10];
                        String price = segments[11];
                        contracts.add(new LeaseContract(date, customerName, customerEmail, new Vehicle(Integer.parseInt(vin), Integer.parseInt(vehicleYear), make, model, vehicleType, color, Integer.parseInt(odometer), Double.parseDouble(price))));
                    }
                    //Length of Sale
                    else if (segments.length == 18) {
                        String date = segments[1];
                        String customerName = segments[2];
                        String customerEmail = segments[3];
                        String vin = segments[4];
                        String vehicleYear = segments[5];
                        String make = segments[6];
                        String model = segments[7];
                        String vehicleType = segments[8];
                        String color = segments[9];
                        String odometer = segments[10];
                        String price = segments[11];
                        String isFinancing = segments[16];

                        contracts.add(new SalesContract(date, customerName, customerEmail, new Vehicle(Integer.parseInt(vin), Integer.parseInt(vehicleYear), make, model, vehicleType, color, Integer.parseInt(odometer), Double.parseDouble(price)), isFinancing.equals("YES") ? true : false));
                    }
                }
                buffRead.close();
                return contracts;
            } catch (IOException e) {
                System.out.printf("Something went wrong on our end :(");
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }

}