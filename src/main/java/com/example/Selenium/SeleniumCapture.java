package com.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class SeleniumCapture {

    public static String CaptureScreen(String url) throws InterruptedException { //set the location of chrome browser


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\arman\\Downloads\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        driver.get(url); // url parameter

        Thread.sleep(5000);

        // Fullscreen button click
        WebElement button = driver.findElement(By.xpath("//*[@id=\"alarmmap\"]/div[2]/div[1]/div[1]/a"));
        button.click();

        Thread.sleep(5000);

        // Screenshot of map as Base64
        WebElement map = driver.findElement(By.xpath("//*[@id='alarmmap'] "));
        String screenshot = map.getScreenshotAs(OutputType.BASE64);

        driver.quit();
        return screenshot;
    }
}
