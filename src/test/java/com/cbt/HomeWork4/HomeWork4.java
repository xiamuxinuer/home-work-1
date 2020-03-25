package com.cbt.HomeWork4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class HomeWork4 {
    WebDriver  driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
    @Test
    public void Days() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        Thread.sleep(3000);
        WebElement checkBox1= driver.findElement(By.cssSelector("#gwt-debug-cwCheckBox-Friday-input"));
        checkBox1.click();
        Thread.sleep(3000);
        String nameOfTheDay=driver.findElement(By.cssSelector("#gwt-debug-cwCheckBox-Friday-label")).getText();
        System.out.println(nameOfTheDay);
        checkBox1.click();
        Thread.sleep(3000);
        checkBox1.click();
        Thread.sleep(3000);
    }

 @Test
 public void todaysDate(){
        driver.get("http://practice.cybertekschool.com/dropdown");
     Select selectYear=new Select(driver.findElement(By.id("year")));
     Select selectMonth=new Select(driver.findElement(By.id("month")));
     Select selectDay=new Select(driver.findElement(By.id("day")));

     String actualYear= selectYear.getFirstSelectedOption().getAttribute("value");
     String actualMonth=selectMonth.getFirstSelectedOption().getText();
     String actualDay=selectDay.getFirstSelectedOption().getAttribute("value");
     String expectedYear="2020";
     String expectedMonth="March";
     String expectedDay="25";

     Assert.assertEquals(actualYear,expectedYear);
     Assert.assertEquals(actualMonth,expectedMonth);
     Assert.assertEquals(actualDay,expectedDay);

 }

@Test
    public void yearsMonthsDays() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
    Select selectYear=new Select(driver.findElement(By.id("year")));
    selectYear.selectByValue("2019");
    Select selectMonth=new Select(driver.findElement(By.id("month")));
    selectMonth.selectByVisibleText("January");
    Select selectDay=new Select(driver.findElement(By.id("day")));
    List<WebElement> days=selectDay.getOptions();
    String lastDayOfMonth= days.get(days.size()-1).getAttribute("value");
    String expected="31";
    Assert.assertEquals(lastDayOfMonth,expected);
    selectYear.selectByValue("2020");
    selectMonth.selectByVisibleText("February");
    Thread.sleep(3000);
    days=selectDay.getOptions();
    String lastDayOfMonth2= days.get(days.size()-1).getAttribute("value");
    String expected2="29";
    Assert.assertEquals(lastDayOfMonth2,expected2);
}
@Test
    public void departmentsSort() {
    driver.get("https://www.amazon.com");
    WebElement allButton = driver.findElement(By.xpath("//span[text()='All']"));
    String actualText = allButton.getText();
    Assert.assertEquals(actualText, "All");

    Select dropdownBox = new Select(driver.findElement(By.id("searchDropdownBox")));
    List<WebElement> allOptions = dropdownBox.getOptions();
    for (int i = 0; i < allOptions.size() - 1; i++) {
        System.out.println(allOptions.get(i).getText());
        String option1 = allOptions.get(i).getText();
        String option2 = allOptions.get(i + 1).getText();
        Assert.assertTrue(option1.charAt(0) < option2.charAt(0));

    }
}

   @Test
   public void mainDepartments() {
       driver.get("https://www.amazon.com/gp/site-directory");
       Select dropdownBox = new Select(driver.findElement(By.id("searchDropdownBox")));
       List<WebElement> allOptions = dropdownBox.getOptions();
       List<WebElement> mainDepartmentsNameList = driver.findElements(By.tagName("h2"));
       for (WebElement eachDepartment : mainDepartmentsNameList) {
           Assert.assertTrue(allOptions.contains(eachDepartment));
       }
   }
@Test
    public void links() {
    driver.get("https://www.w3schools.com");
    List<WebElement> allLinks = driver.findElements(By.tagName("a"));

    for (WebElement eachLink : allLinks) {
        if (eachLink.isDisplayed()) {
            System.out.println(eachLink.getText());
            System.out.println(eachLink.getAttribute("href"));
        }
    }
}

@Test
        public void validLinks(){
        driver.get("https://www.selenium.dev/documentation/en/");
        List<WebElement> allLinks= driver.findElements(By.tagName("a"));
        for (WebElement eachLink:allLinks){
            Assert.assertTrue(eachLink.isEnabled());
        }
    }

    @Test
    public void cart() throws InterruptedException {
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        driver.manage().window().maximize();






    }

















}






