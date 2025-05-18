package com.eRailtest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DragAndDrop {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void testDragAndDrop() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        action.dragAndDrop(drag,drop).build().perform();

    }
@Test

public void testAmazonPriceCheck() throws InterruptedException {
    amazon("Samsung Galaxy A35 5G (Awesome Navy, 8GB RAM, 128GB Storage)");
}
    public void amazon(String MobilePhone) throws InterruptedException {
//        WebDriver driver=new ChromeDriver();
    driver.get("https://www.amazon.in");
    Thread.sleep(10000);
    WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));
    searchbar.clear();
    searchbar.sendKeys("samsung");
    driver.findElement(By.id("nav-search-submit-button")).click();
    WebElement price = driver.findElement(By.xpath("//span[contains(text(),'" + MobilePhone + "')]/ancestor::div[@class=\"puisg-col-inner\"]//descendant::span[@class=\"a-price-whole\"]"));
    Thread.sleep(3000);
    // Scroll it into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", price);
    System.out.println("Price: " + price.getText());

    }


    @Test
    public void getMobilePrices()  {
        // Launch Amazon
////        setup("https://www.amazon.in/");
        driver.get("https://www.amazon.in/");
//
//        Thread.sleep(10000);
//        // Enter mobile name in search bar and click search
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(MobileNames);
//        driver.findElement(By.id("nav-search-submit-button")).click();
//
//        // Scroll down to ensure prices are visible
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 250);");
//
//        // Wait for elements to load properly (use WebDriverWait ideally)
//        Thread.sleep(3000);
//
//        // Capture all price elements matching the mobile name
//        List<WebElement> prices = driver.findElements(By.xpath("//span[contains(text(),'" + MobileNames + "')]/ancestor::div[contains(@class,'s-result-item')]//span[@class='a-price-whole']"));
//
//        // Print out the prices
//        for (WebElement element : prices) {
//            System.out.println("Expected Price of the mobile is = " + element.getText());
//        }
    }



    @Test
    public void testDatePicker() throws InterruptedException {
        driver.get("https://jqueryui.com/datepicker/");
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Frame = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
//        WebElement Frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(Frame);
        WebElement inputDate = driver.findElement(By.id("datepicker"));
        String targetDate = "03/13/2025";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];",inputDate,targetDate);
        System.out.println("Selected Date: " + inputDate.getAttribute("value"));
    }

    @Test
    public void takeScreenShot() throws InterruptedException, IOException {
        driver.get("https://jqueryui.com/datepicker/");
        Thread.sleep(3000);
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File scr = ts.getScreenshotAs(OutputType.FILE);
        File dist = new File("./ScreenShot/ss.png");
        FileUtils.copyFile(scr,dist);
    }

    @Test
    public void windowHandles() {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.naukri.com/");
        Set<String> allwh = driver.getWindowHandles();
        int count = allwh.size();
        System.out.println(count);
        for(String wh:allwh) {
            driver.switchTo().window(wh);
            String title = driver.getTitle();
            System.out.println(title);

        }
        driver.quit();
    }

    @AfterTest
    public void  TearDown(){
        driver.quit();
    }

}
