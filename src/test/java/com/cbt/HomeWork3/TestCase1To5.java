package com.cbt.HomeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1To5 {
    private WebDriver driver;

    @BeforeMethod
    public void SetUp() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();

        driver=new ChromeDriver();

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Registration Form")).click();
        Thread.sleep(3000);
    }

@Test
    public void TestCase1(){
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("wrong_dob");
        WebElement message= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]"));
        String expected="The date of birth is not valid";
    Assert.assertTrue(message.isDisplayed());
    Assert.assertEquals(message.getText(),expected);
}

@Test
public void TestCase2() throws InterruptedException {
   WebElement cOption=  driver.findElement(By.xpath("//label[text()='C++']"));
   Thread.sleep(2000);
   WebElement javaOption=driver.findElement(By.xpath("//label[text()='Java']"));
    Thread.sleep(2000);
   WebElement javaScriptOption=driver.findElement(By.xpath("//label[text()='JavaScript']"));
    Thread.sleep(2000);
   Assert.assertTrue(cOption.isDisplayed());
    Assert.assertTrue(javaOption.isDisplayed());
    Assert.assertTrue(javaScriptOption.isDisplayed());
}

@Test
public void TestCase3() throws InterruptedException {
   driver.findElement(By.name("firstname")).sendKeys("a");
   Thread.sleep(3000);
   String actual= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]")).getText();
   String expected="first name must be more than 2 and less than 64 characters long";
   Assert.assertEquals(actual,expected,"message is not match");
}

@Test
public void TestCase4() throws InterruptedException {
    driver.findElement(By.name("lastname")).sendKeys("p");
    Thread.sleep(3000);

    String actual=driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[2]")).getText();
    String expected="The last name must be more than 2 and less than 64 characters long";
    Assert.assertEquals(actual,expected,"message is not match");
}

@Test
public void TestCas5() throws InterruptedException {
        driver.findElement(By.name("firstname")).sendKeys("emma");
        driver.findElement(By.name("lastname")).sendKeys("xiao");
        driver.findElement(By.name("username")).sendKeys("cybertek");
        driver.findElement(By.name("email")).sendKeys("cybertek@email.com");
        driver.findElement(By.name("password")).sendKeys("cybertek123");
        driver.findElement(By.name("phone")).sendKeys("405-331-4565");
        driver.findElement(By.cssSelector("input[value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys("12/15/1984");
    Select  department= new Select(driver.findElement(By.name("department")));
            department.selectByValue("DE");

     Select jobTitle=new Select(driver.findElement(By.name("job_title")));
            jobTitle.selectByVisibleText("Manager");
            driver.findElement(By.id("inlineCheckbox2")).click();
            driver.findElement(By.id("wooden_spoon")).click();
Thread.sleep(3000);
       String message=  driver.findElement(By.tagName("p")).getText();
       String expected="You've successfully completed registration!";
       Assert.assertEquals(message,expected,"message is not match");

}

@AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
}




}
