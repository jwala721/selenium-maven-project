package com.eRailtest;


import PageObjects.ERailPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import genericutilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;


public class ERAILTest {
    WebDriver driver;
    ERailPage eRailPage;
    ExtentReports extent;
    ExtentTest test;
    String excelPath = "test-data/TestData.xlsx";
    String sheetName = "stations";

    @BeforeTest
    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        ExtentSparkReporter spark = new ExtentSparkReporter("testOutput/ERailTestReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Test
    public void testERailAutomation() throws IOException, InterruptedException {
        test = extent.createTest("ERail Test");
        driver.get("https://erail.in/");

        eRailPage = new ERailPage(driver);
        eRailPage.selectFromStation("DEL");
        String selectedStation = eRailPage.selectFourthStation();
        System.out.println("Selected Station: " + selectedStation);
        Thread.sleep(5000);
        eRailPage.selectFromStation("DEL");

        // Read expected station names from Excel
        List<String> expectedStations = ExcelUtils.readFromExcel(excelPath, sheetName);
        System.out.println("Expected Stations: " + expectedStations);

        // Get actual station names from the dropdown
        List<String> actualStations = eRailPage.getDropdownStations();
        System.out.println("Actual Stations: " + actualStations);

        // Find missing stations
        List<String> missingStations = expectedStations.stream()
                .filter(expected -> !actualStations.contains(expected))
                .collect(Collectors.toList());

        // If there are missing stations, print them and fail the test
        if (!missingStations.isEmpty()) {
            System.out.println("Missing Stations: " + missingStations);
            Assert.fail("The following stations do not match: " + missingStations);
        } else {
            System.out.println("All stations match!");
        }


      /* boolean result = ExcelUtils.checkDDListFromUIAndExcel(driver,"places");
        if(result == true) {
            System.out.println("Test Passed !! ");
        }else {
            System.out.println("Test Failed !! ");
        }*/

        eRailPage.selectDate(30);

        test.pass("ERail Automation Test Passed");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
        extent.flush();
    }
}

