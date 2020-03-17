package com.cbt.HomeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.compressors.brotli.BrotliUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7To8 {
     private  WebDriver driver;


  @BeforeMethod
  public void SetUp() throws InterruptedException {
      WebDriverManager.chromedriver().version("79").setup();
      driver=new ChromeDriver();
      driver.get("https://practice-cybertekschool.herokuapp.com");
      driver.manage().window().maximize();
      Thread.sleep(3000);
  }

@Test
    public void testCase7() throws InterruptedException {
      driver.findElement(By.linkText("File Upload")).click();
    Thread.sleep(3000);

    WebElement chooseFile=driver.findElement(By.id("file-upload"));

    String filePath="C:\\Users\\akbar\\Desktop\\New Microsoft Word 文档.docx";

    chooseFile.sendKeys(filePath);
    Thread.sleep(2000);
    driver.findElement(By.id("file-submit")).click();
    Thread.sleep(2000);

    String subject= driver.findElement(By.tagName("h3")).getText();
    String expected="File Uploaded!";
    Assert.assertEquals(subject,expected);

   WebElement message= driver.findElement(By.id("uploaded-files"));
   Assert.assertTrue(message.isDisplayed());
   String actual=message.getText();
   String expectedMessage="New Microsoft Word 文档.docx";
   Assert.assertEquals(actual,expectedMessage);


}

@Test
public void testCase8() throws InterruptedException {
      driver.findElement(By.linkText("Autocomplete")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("myCountry")).sendKeys("United States of America");

    Thread.sleep(2000);
    driver.findElement(By.cssSelector("input[value='Submit']")).click();
    Thread.sleep(2000);
    String result=  driver.findElement(By.id("result")).getText();
    String expected="You selected: United States of America";
    Assert.assertEquals(result,expected);
}


@AfterMethod
    public  void tearDown(){

      driver.quit();
}




}
