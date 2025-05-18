package com.eRailtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeX {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
//write a generic XPath expression to extract the price of a mobile phone  when give the mobile name from Amazon India
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
//     Write a generic XPath to fetch the mobile name  based on the price https://www.amazon.in/s?
    public void testMobileCheck () throws InterruptedException {
        amazonMobileName("12,999");
    }
    public void amazonMobileName (String MobilePrice) throws InterruptedException {
        driver.get("https://www.amazon.in");
        Thread.sleep(10000);
        WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));
        searchbar.clear();
        searchbar.sendKeys("samsung");
        driver.findElement(By.id("nav-search-submit-button")).click();
        WebElement MobileName = driver.findElement(By.xpath("//span[contains(text(),'" + MobilePrice + "')]/ancestor::div[@class=\"puisg-col-inner\"]//descendant::h2/span"));
        Thread.sleep(3000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MobileName);
        System.out.println("Mobile Name : " + MobileName.getText());
    }


    @Test
//    write a generic xpath for all the links like kilos , Mobiles , fashion etc in https://www.flipkart.com/

    public void getTabName() throws InterruptedException {
        flipkartTab("Fashion");
    }

    public void flipkartTab(String tabName) throws InterruptedException {
        driver.get("https://www.flipkart.com/");
        Thread.sleep(5000);
        WebElement tab = driver.findElement(By.xpath("//div[contains(@class,\"emupdz\")]/descendant::span[text()='" + tabName + "']"));
        System.out.println("Tab Name: " + tab.getText());
    }

    @Test
//    write a xpath to check days checkbox like sunday monday based on the day https://testautomationpractice.blogspot.com/

    public void testCheckbox() throws InterruptedException {
        checkbox("Monday");
    }

    public void checkbox(String days) throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com");
        WebElement day = driver.findElement(By.xpath("//label[text()=\"Days:\"]/parent::div[@class=\"form-group\"]/descendant::label[text()='" + days + "']"));
//        WebElement day = driver.findElement(By.xpath("//input[@type=\"checkbox\" and @value='" + days + "']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", day);
        Thread.sleep(5000);
        day.click();
    }


    @Test
//    Search Iphone in the flipkart and get the rating based on the mobile phone :https://www.flipkart.com/search?q=iphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off

    public void getIphone() throws InterruptedException {
        flipkartIphone("Apple iPhone 15 (Black, 128 GB)");
    }

    public void flipkartIphone(String MobileName) throws InterruptedException {
        driver.get("https://www.flipkart.com/");
        Thread.sleep(5000);
        driver.findElement(By.name("q")).sendKeys("iphone");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@title=\"Search for Products, Brands and More\"]")).click();
        WebElement rate = driver.findElement(By.xpath("//div[contains(text(),'" + MobileName + "')]/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"XQDdHH\"]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",rate);
        System.out.println("Rating : " +rate.getText());
    }


    @Test
//Find the "Add to Cart" button using the product title in amazon.in.. write generic Xpath

    public void testAddCartButton() throws InterruptedException {
        addToCart("Samsung Galaxy M16 5G (Mint Green, 6GB RAM, 128 GB Storage)");
    }

    public void addToCart(String MobileName) throws InterruptedException {
        driver.get("https://www.amazon.in");
        Thread.sleep(10000);
        WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));
        searchbar.clear();
        searchbar.sendKeys("samsung");
        driver.findElement(By.id("nav-search-submit-button")).click();
        WebElement cart = driver.findElement(By.xpath("//span[contains(text(),'" + MobileName + "')]/ancestor::div[@class=\"puisg-col-inner\"]//descendant::button[@name=\"submit.addToCart\"]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",cart);
        System.out.println("add to cart button: " + cart.getText());

    }


    @Test
//    https://testautomationpractice.blogspot.com/ opne this link go to static webtable based on the author find the price

    public void testAuthorBookPrice() throws InterruptedException {
        staticTable("Animesh");
    }

    public void staticTable(String Name) throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com");
        WebElement scrolltoview = driver.findElement(By.xpath("//table[@name=\"BookTable\"]"));
        Thread.sleep(3000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",scrolltoview);
        List<WebElement> allprice = driver.findElements(By.xpath("//td[text()='" + Name + "']/following-sibling::td[2]"));

        for (WebElement price:allprice){
            System.out.println("Price of book:" +price.getText());
        }
    }

    @Test
//    https://testautomationpractice.blogspot.com/ open this link go to static webtable write the Xpath to get al the subject names

    public void allSubject() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com");
        WebElement scrolltoview = driver.findElement(By.xpath("//table[@name=\"BookTable\"]"));
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrolltoview);
        List<WebElement> allBooks = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//descendant::td[3]"));

        for (WebElement subject : allBooks) {
            System.out.println("Name of Subjects: " + subject.getText());
        }
    }

    @Test
//https://testautomationpractice.blogspot.com/ based on the gender select the radio button

    public void testRadioButton() throws InterruptedException {
        radioButtonGender("Female");
    }

    public void radioButtonGender(String selectGender) throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com");
        Thread.sleep(3000);
        WebElement gender = driver.findElement(By.xpath("//label[text()=\"Gender:\"]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",gender);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()=\"Gender:\"]/ancestor::div[@class=\"form-group\"]/descendant::label[text()='" + selectGender +"']")).click();

    }

    @Test
//    Get all the product name which is having price less than 1000https://www.ikea.com/in/en/search/?q=lamp

    public void ikeaProduct() throws InterruptedException {
        driver.get("https://www.ikea.com/in/en/search/?q=lamp");
        List<WebElement> product = driver.findElements(By.xpath("//span[text()<1000]/ancestor::a/descendant::span[contains(@class,\"product-name\")]"));
        Thread.sleep(3000);
        for (WebElement allProduct:product){
            System.out.println("All lamp price less than 1000: " + allProduct.getText());
        }
    }



    @AfterTest
    public void  TearDown(){
        driver.quit();
    }
}



