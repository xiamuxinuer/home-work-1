package com.cbt.HomeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase9To12 {
    private WebDriver driver;

    @BeforeMethod
    public  void  setUp() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Status Codes")).click();
        Thread.sleep(3000);
    }


       @Test
       public void testCase9() throws InterruptedException {
        driver.findElement(By.linkText("200")).click();
        Thread.sleep(3000);
           String text = driver.findElement(By.tagName("p")).getText();

           String firstText = text.substring(0, text.indexOf(" "));
           System.out.println(firstText);


    }

    @Test
    public void testCase10() throws InterruptedException {
        driver.findElement(By.linkText("301")).click();
        Thread.sleep(3000);
        String text = driver.findElement(By.tagName("p")).getText();

        String firstText = text.substring(0, text.indexOf(" "));
        System.out.println(firstText);
    }


    @Test
    public void testCase11() throws InterruptedException {
        driver.findElement(By.linkText("404")).click();
        Thread.sleep(3000);
        String text = driver.findElement(By.tagName("p")).getText();

        String firstText = text.substring(0, text.indexOf(" "));
        System.out.println(firstText);
    }


    @Test
    public void testCase12() throws InterruptedException {
        driver.findElement(By.linkText("500")).click();
        Thread.sleep(3000);
        String text = driver.findElement(By.tagName("p")).getText();

        String firstText = text.substring(0, text.indexOf(" "));
        System.out.println(firstText);
    }





    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
