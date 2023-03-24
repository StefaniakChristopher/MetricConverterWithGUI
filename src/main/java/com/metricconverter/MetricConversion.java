package com.metricconverter;

public class MetricConversion {
    public String conversion(String convType, double quantity){
        double convertedValue = 0;
        String unitSuffix = "";
        switch (convType) {
            case "KilogramsToPounds":
                convertedValue = quantity * 2.20462;
                unitSuffix = " lbs";
                break;
            case "KilometersToMiles":
                convertedValue = quantity * 2.2046;
                unitSuffix = " mi";
                break;
            case "GramsToOunces":
                convertedValue = quantity * 0.035274;
                unitSuffix = " oz";
                break;
            case "SquareFeetToAcres":
                convertedValue = quantity * 0.0000229568;
                unitSuffix = " Acres";
                break;
        }
        String presentableValue = convertedValue + unitSuffix;
        return presentableValue;
    }
  }