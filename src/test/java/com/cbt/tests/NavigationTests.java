package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import net.bytebuddy.implementation.bytecode.Throw;
import org.jsoup.helper.StringUtil;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) throws InterruptedException {
chromeDriver();
//FireFoxDriver();
//EdgeDriver();


    }


    public static void chromeDriver () throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");

        driver.get("http://Google.com");
       String  googleTitle=driver.getTitle();
        Thread.sleep(3000);

        driver.navigate().to("https://etsy.com");
        Thread.sleep(3000);
        String etsyTitle=driver.getTitle();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        String titleGooogle=driver.getTitle();

        StringUtility.verifyEquals(googleTitle,titleGooogle);

        driver.navigate().forward();
        Thread.sleep(3000);
        String titleEsty=driver.getTitle();
        StringUtility.verifyEquals(etsyTitle,titleEsty);



        Thread.sleep(2000);
        driver.quit();
    }

    public static void FireFoxDriver () throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("FirefoxDriver");

        Thread.sleep(2000);
        driver.quit();

    }

   public static void EdgeDriver() throws  InterruptedException {

       WebDriver driver = BrowserFactory.getDriver("EdgeDriver");

       Thread.sleep(2000);
       driver.quit();
   }


}
