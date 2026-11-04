
package com.waterquality;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

public class WaterQualityAnalyzerTest {

    WaterQualityAnalyzer analyzer = new WaterQualityAnalyzer();

    @Test
    public void testValidInput() {
        assertTrue(analyzer.isValid(7.0, 2.0, 25.0, 300.0));
    }

    @Test
    public void testInvalidPH() {
        assertFalse(analyzer.isValid(15.0, 2.0, 25.0, 300.0));
    }

    @Test
    public void testGoodWaterQuality() {
        assertEquals("Good",
                analyzer.classifyWaterQuality(7.0, 2.0, 25.0, 300.0));
    }

    @Test
    public void testNeedsFurtherTesting() {
        assertEquals("Needs Further Testing",
                analyzer.classifyWaterQuality(9.0, 2.0, 25.0, 300.0));
    }

    @Test
    public void testNegativeTurbidity() {
        assertEquals("Invalid Input",
                analyzer.classifyWaterQuality(7.0, -1.0, 25.0, 300.0));
    }

    @Test
    public void testDatasetFileExists() {
        InputStream input = getClass().getClassLoader()
                .getResourceAsStream("water_quality_dataset.csv");

        assertNotNull(input, "Dataset file should exist");

        try {
            input.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDatasetContainsTenReadings() throws Exception {

        InputStream input = getClass().getClassLoader()
                .getResourceAsStream("water_quality_dataset.csv");

        assertNotNull(input);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(input));

        reader.readLine(); // Skip header

        int count = 0;
        while (reader.readLine() != null) {
            count++;
        }

        reader.close();

        assertEquals(10, count);
    }
}
