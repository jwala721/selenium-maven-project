package com.eRailtest;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class screenShort {

    @Test
    public void testScreenShort() throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://erail.in/");
        TakesScreenshot t = (TakesScreenshot) driver;
        File Src = t.getScreenshotAs(OutputType.FILE);
        File dest = new File("./ScreenShot/ss.png");
        FileUtils.copyFile(Src, dest);
        driver.close();

    }
}
