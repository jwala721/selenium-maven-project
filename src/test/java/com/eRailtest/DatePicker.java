package com.eRailtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DatePicker {
    public static void main(String[] args) {
        // Set the path to your WebDriver executable


        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the date picker demo page (replace with your target URL)
        driver.get("file:///C:/Users/JWALA%20KUMAR/OneDrive/Desktop/DemoApp.html");



        // Locate the date picker input field
        // Wait for the date picker input to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement datePickerInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date")));

        String targetDate = "2021-11-20"; // Format: YYYY-MM-DD (required for <input type="date">)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", datePickerInput, targetDate);

        // Alternatively, you can use sendKeys to set the date
        // datePickerInput.clear(); // Clear any existing value
        // datePickerInput.sendKeys(targetDate);

        // Print the selected date
        System.out.println("Selected Date: " + datePickerInput.getAttribute("value"));

        // Close the browser
//        driver.quit();
    }
}
