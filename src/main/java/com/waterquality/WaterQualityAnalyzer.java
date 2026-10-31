package com.waterquality;

public class WaterQualityAnalyzer {

    public boolean isValid(double ph, double turbidity,
                           double temperature, double conductivity) {

        return ph >= 0 && ph <= 14
                && turbidity >= 0
                && temperature >= 0
                && conductivity >= 0;
    }

    public String classifyWaterQuality(double ph, double turbidity,
                                       double temperature, double conductivity) {

        if (!isValid(ph, turbidity, temperature, conductivity)) {
            return "Invalid Input";
        }

        if (ph >= 6.5 && ph <= 8.5
                && turbidity <= 5
                && temperature <= 35
                && conductivity <= 500) {
            return "Good";
        }

        return "Needs Further Testing";
    }

    public static void main(String[] args) {

        WaterQualityAnalyzer analyzer = new WaterQualityAnalyzer();

        double ph = 7.0;
        double turbidity = 2.0;
        double temperature = 25.0;
        double conductivity = 300.0;

        System.out.println("WATER QUALITY ANALYSIS");
        System.out.println("----------------------");
        System.out.println("pH: " + ph);
        System.out.println("Turbidity: " + turbidity + " NTU");
        System.out.println("Temperature: " + temperature + " C");
        System.out.println("Conductivity: " + conductivity + " uS/cm");

        String status = analyzer.classifyWaterQuality(
                ph, turbidity, temperature, conductivity);

        System.out.println("Water Quality Status: " + status);
    }
}
