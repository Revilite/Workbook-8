package com.pluralsight.contract;

import com.pluralsight.cars.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {

    @Test
    void getSalesTaxAmount() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 5000);
        SalesContract contract = new SalesContract("Jacob Lockhart", "procoder165@gmail.com", vehicle, true);

        double salesTax = 250;

        assertEquals(salesTax, contract.getSalesTaxAmount());
    }

    @Test
    void getRecordingFee() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 5000);
        SalesContract contract = new SalesContract("Jacob Lockhart", "procoder165@gmail.com", vehicle, true);

        double recordingFee = 100;

        assertEquals(recordingFee, contract.getRecordingFee());
    }

    @Test
    void vehiclePrice_is_less_than_10000_processingFee_is_295() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 5000);
        SalesContract contract = new SalesContract("Jacob Lockhart", "procoder165@gmail.com", vehicle, true);

        double processingFee = 295;

        assertEquals(processingFee, contract.getProcessingFee());
    }

    @Test
    void vehiclePrice_is_more_than_10000_processingFee_is_495() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 15000);
        SalesContract contract = new SalesContract("Jacob Lockhart", "procoder165@gmail.com", vehicle, true);

        double processingFee = 495;

        assertEquals(processingFee, contract.getProcessingFee());
    }


    @Test
    void getTotalPrice() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 5000);
        SalesContract contract = new SalesContract("Jacob Lockhart", "procoder165@gmail.com", vehicle, true);

        double totalPrice = 1495.07;

        assertEquals(totalPrice, contract.getTotalPrice());
    }

    @Test
    void vehiclePrice_is_less_than_10000_monthlyPayment_is_525_percent_of_totalPrice() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 5000);
        SalesContract contract = new SalesContract("Jacob Lockhart", "procoder165@gmail.com", vehicle, true);

        double monthlyPrice = 43.76;

        assertEquals(monthlyPrice, contract.getMonthlyPayment());
    }

    @Test
    void vehiclePrice_is_more_than_10000_monthlyPayment_is_425_percent_of_totalPrice() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 15000);
        SalesContract contract = new SalesContract("Jacob Lockhart", "procoder165@gmail.com", vehicle, true);

        double monthlyPrice = 694.66;

        assertEquals(monthlyPrice, contract.getMonthlyPayment());
    }

    @Test
    void isFinancing_is_false_monthlyPrice_is_0() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 15000);
        SalesContract contract = new SalesContract("Jacob Lockhart", "procoder165@gmail.com", vehicle, false);

        double monthlyPrice = 0;

        assertEquals(monthlyPrice, contract.getMonthlyPayment());
    }
}