package com.pluralsight.contract;

import com.pluralsight.cars.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LeaseContractTest {

    @Test
    void getExpectedEndingValue() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 5000);
        LeaseContract contract = new LeaseContract("Jacob Lockhart", "Procoder165@gmail.com", vehicle);

        double expectedEndingValue = 2500;

        assertEquals(expectedEndingValue, contract.getExpectedEndingValue());
    }

    @Test
    void getLeaseFee() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 5000);
        LeaseContract contract = new LeaseContract("Jacob Lockhart", "Procoder165@gmail.com", vehicle);

        double leaseFee = 350;

        assertEquals(leaseFee, contract.getLeaseFee());
    }

    @Test
    void getMonthlyPayment() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 5000);
        LeaseContract contract = new LeaseContract("Jacob Lockhart", "Procoder165@gmail.com", vehicle);

        double monthlyPayment = 0;//?????

        assertEquals(monthlyPayment, contract.getMonthlyPayment());
    }

    @Test
    void getTotalPrice() {
        Vehicle vehicle = new Vehicle(123124, 2000, "Toyota", "Corolla", "Car", "Silver", 209000, 5000);
        LeaseContract contract = new LeaseContract("Jacob Lockhart", "Procoder165@gmail.com", vehicle);

        double totalPrice = 2850;

        assertEquals(totalPrice, contract.getTotalPrice());
    }
}