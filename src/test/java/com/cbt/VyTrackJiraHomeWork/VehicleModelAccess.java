package com.cbt.VyTrackJiraHomeWork;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehicleModelAccess {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
@Test
    public void authorizedUser() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.partialLinkText("Vehicles Model")).click();
        Thread.sleep(5000);
        String actual=driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1")).getText();
        String expected="All Vehicles Model";
    Assert.assertEquals(actual,expected);
}

@Test
    public void nonAuthorizedUser() throws InterruptedException {
    driver.findElement(By.id("prependedInput")).sendKeys("user1");
    driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
    Thread.sleep(10000);
    driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();
    Thread.sleep(5000);
    driver.findElement(By.partialLinkText("Vehicles Model")).click();
    Thread.sleep(5000);
    String actual=driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/h1")).getText();
    String expected="Vehicles Model";
    Assert.assertEquals(actual,expected);
}



}
