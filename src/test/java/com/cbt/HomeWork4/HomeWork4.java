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
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        Thread.sleep(3000);
        WebElement name=driver.findElement(By.linkText("OXO 1130880 Good Grips Wooden Corner Spoon & Scraper,Brown"));
        String nameText=name.getText();


//        WebElement price=driver.findElement(By.xpath("//*[@id=\"anonCarousel1\"]/ol/li[1]/div/div/div[4]/div/div/a/span/span[1]"));
//        String priceText=price.getText();
        name.click();
        Thread.sleep(2000);

        String productTitle=driver.findElement(By.id("productTitle")).getText();
        Assert.assertEquals(nameText,productTitle);

        String productPrice=driver.findElement(By.id("priceblock_ourprice")).getText();

        WebElement addCartButton=driver.findElement(By.id("add-to-cart-button"));
        Assert.assertTrue(addCartButton.isDisplayed());
    }

@Test
    public void prime() throws InterruptedException {
    driver.get("https://amazon.com");
    driver.manage().window().maximize();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
    Thread.sleep(3000);
    String firstProductName=driver.findElement(By.linkText("HANSGO Small Wooden Spoons, 6PCS Small Soup Spoons Serving Spoons Wooden Teaspoon for Coffee Tea Jam Bath Salts, 5\"")).getText();
    WebElement primeCheckBox=driver.findElement(By.xpath("//*[@id=\"p_85/2470955011\"]/span/a/div/label/i"));
    Thread.sleep(3000);
    primeCheckBox.click();
    Thread.sleep(5000);


    WebElement firstPrimeProductName=driver.findElement(By.linkText("HANSGO Small Wooden Spoons, 6PCS Small Soup Spoons Serving Spoons Wooden Teaspoon for Coffee Tea Jam Bath Salts, 5\""));
    Assert.assertEquals(firstProductName,firstPrimeProductName.getText());


    driver.findElement(By.xpath("//*[@id=\"p_89/Folkulture\"]/span/a/div/label/i")).click();
    WebElement newFirstProductName=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div[1]/div/span/div/div/div[2]/h2"));
    Assert.assertEquals(newFirstProductName.getText(),firstProductName);

}

@Test
    public void moreSpoon() throws InterruptedException {
        driver.get("https://amazon.com");
    driver.manage().window().maximize();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
    Thread.sleep(3000);
    List<WebElement> allBrands=driver.findElements(By.xpath("//*[@id=\"brandsRefinements\"]/ul/li/span"));
    String brandName="";
    for (WebElement eachBrand:allBrands){
      brandName+=eachBrand.getText()+",";
    }
    WebElement primeCheckBox=driver.findElement(By.xpath("//*[@id=\"p_85/2470955011\"]/span/a/div/label/i"));
    primeCheckBox.click();
    Thread.sleep(3000);


    List<WebElement> primeAllBrands=driver.findElements(By.xpath("//*[@id=\"brandsRefinements\"]/ul/li/span"));
    String primeBrandName="";
    for (WebElement eachBrand:primeAllBrands){
        primeBrandName+=eachBrand.getText()+",";
    }

    Assert.assertEquals(brandName,primeBrandName);
}













}






