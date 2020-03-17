package com.cbt.HomeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase6 {

    private WebDriver driver;


   @Test
  public void testCase6() throws InterruptedException {
       WebDriverManager.chromedriver().version("79").setup();
       driver=new ChromeDriver();
       driver.get("https://www.tempmailaddress.com");
       Thread.sleep(3000);
       String email= driver.findElement(By.id("email")).getText();

       driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
       Thread.sleep(3000);
       driver.findElement(By.linkText("Sign Up For Mailing List")).click();
       Thread.sleep(3000);
       driver.findElement(By.name("full_name")).sendKeys("emmaxiao");
       driver.findElement(By.name("email")).sendKeys(email);
       driver.findElement(By.name("wooden_spoon")).click();
       Thread.sleep(3000);

       String signUpMessage= driver.findElement(By.tagName("h3")).getText();
       String expected="Thank you for signing up. Click the button below to return to the home page.";
       Assert.assertEquals(signUpMessage,expected);
       driver.navigate().to("https://www.tempmailaddress.com");

       driver.manage().window().maximize();
       Thread.sleep(5000);

       WebElement element= driver.findElement(By.cssSelector("td[class='from']"));
       Assert.assertTrue(element.isDisplayed());
       element.click();
       Thread.sleep(3000);
       String  emailFrom= driver.findElement(By.id("odesilatel")).getText();
       String expectedMessage= "do-not-reply@practice.cybertekschool.com";
         Assert.assertEquals(emailFrom,expectedMessage);
       String subject= driver.findElement(By.id("predmet")).getText();
       String  expectedsubject="Thanks for subscribing to practice.cybertekschool.com!";


       driver.quit();
   }








}
//Step 1. Go to "https://www.tempmailaddress.com/"
// Step 2. Copy and save email as a string.
// Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
// Step 4. And click on “Sign Up For Mailing List".
// Step 5. Enter any valid name.
// Step 6. Enter email from the Step 2.
// Step 7. Click Sign Up
// Step8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
// Step 9. Navigate back to the “https://www.tempmailaddress.com/”
// Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
// Step 11. Click on that email to open it.
// Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
// Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”