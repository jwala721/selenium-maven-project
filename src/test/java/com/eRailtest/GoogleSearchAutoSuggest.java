package com.eRailtest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearchAutoSuggest {
    public static void main(String[] args) {
        // Set up ChromeDriver
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Maximize browser and set implicit wait
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Navigate to Google
        driver.get("https://www.google.com/");

        // Locate the search box and type "Java"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Java");

        // Wait for auto-suggestions to appear
        try {
            Thread.sleep(2000);  // Explicit wait for suggestions to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Capture all auto-suggestions
        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='wM6W7d']"));

        // Get the second last suggestion and click it
        int suggestionCount = suggestions.size();
        if (suggestionCount > 1) {
            WebElement secondLastSuggestion = suggestions.get(suggestionCount - 2);
            secondLastSuggestion.click();
        } else {
            System.out.println("Not enough suggestions found.");
        }

        // Close the browser
        driver.quit();
    }
}
