package org.example.utils;

import org.example.vehicles.Vehicle;

public class FeeCalculator {

    // Calculate fee by delegating to the vehicle's calculateFee method
    public static double calculateFee(int hoursStayed, Vehicle vehicle) {
        return vehicle.calculateFee(hoursStayed); // Use vehicle-specific fee calculation
    }
}
