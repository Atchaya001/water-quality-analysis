# Water Quality Analysis System

## Project Overview

The Water Quality Analysis System is a Java-based application developed to classify water quality using four parameters: pH, Turbidity, Temperature, and Conductivity.

The application validates the input values and displays the water quality status based on predefined demonstration thresholds.

This project also demonstrates the DevOps workflow using Java, Maven, JUnit, Git, GitHub, and Jenkins.

## Problem Statement

Checking water quality manually can be difficult. This project provides a simple Java application to analyze sample water-quality readings and display the corresponding status.

## Technologies Used

- Java 21 – Programming language
- Eclipse IDE – Development environment
- Maven – Build automation tool
- JUnit 5 – Unit testing framework
- Git – Version control
- GitHub – Source code repository
- Jenkins – Continuous Integration
- HTML Publisher Plugin – HTML report publishing

## Water Quality Parameters

1. pH
2. Turbidity
3. Temperature
4. Conductivity

## Project Structure

```text
water-quality-analysis/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/waterquality/
│   │           └── WaterQualityAnalyzer.java
│   │
│   └── test/
│       └── java/
│
├── pom.xml
└── README.md
```

## Water Quality Classification

The application uses the following demonstration conditions:

- pH between 6.5 and 8.5
- Turbidity at most 5 NTU
- Temperature at most 35 °C
- Conductivity at most 500 µS/cm

**Good:** When all configured conditions are satisfied.

**Needs Further Testing:** When the readings do not satisfy the configured conditions.

**Invalid Input:** When invalid values are provided.

*Note: These are demonstration thresholds for this student project and are not a complete regulatory assessment of drinking-water safety.*

## Maven Build

To build the project, execute:

```bash
mvn clean test site package
```

## Run the Application

After generating the JAR file, execute:

```bash
java -jar target/water-quality-analysis-1.0-SNAPSHOT.jar
```

## Unit Testing

JUnit 5 is used to verify the water-quality classification logic.

Test execution result:

- Tests Run: 5
- Failures: 0
- Errors: 0
- Skipped: 0

## Jenkins Integration

Jenkins is configured to:

1. Retrieve source code from GitHub.
2. Execute Maven build commands.
3. Run JUnit test cases.
4. Generate and publish the HTML report.
5. Archive the generated JAR artifact.
6. Copy build artifacts to another Jenkins job.

## Build Artifact

Generated JAR file:

`water-quality-analysis-1.0-SNAPSHOT.jar`

## Project Repository

GitHub: https://github.com/Atchaya001/water-quality-analysis

## Conclusion

This project demonstrates a basic DevOps continuous integration workflow using Java, Maven, JUnit, GitHub, and Jenkins. It automates source-code retrieval, building, testing, report publishing, and artifact archiving.
