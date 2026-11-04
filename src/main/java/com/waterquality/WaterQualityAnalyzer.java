
package com.waterquality;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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

    public void analyzeDataset() {

        try {
            InputStream input = getClass().getClassLoader()
                    .getResourceAsStream("water_quality_dataset.csv");

            if (input == null) {
                System.out.println("Dataset file not found!");
                return;
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(input));

            String line;
            reader.readLine(); // Skip CSV header

            System.out.println("WATER QUALITY DATASET ANALYSIS");
            System.out.println("--------------------------------");

            while ((line = reader.readLine()) != null) {

                String[] values = line.split(",");

                double ph = Double.parseDouble(values[0]);
                double turbidity = Double.parseDouble(values[1]);
                double temperature = Double.parseDouble(values[2]);
                double conductivity = Double.parseDouble(values[3]);

                String status = classifyWaterQuality(
                        ph, turbidity, temperature, conductivity);

                System.out.println(
                        "pH: " + ph
                        + " | Turbidity: " + turbidity
                        + " | Temperature: " + temperature
                        + " | Conductivity: " + conductivity
                        + " | Status: " + status);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading dataset: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        WaterQualityAnalyzer analyzer = new WaterQualityAnalyzer();

        analyzer.analyzeDataset();
    }
}
