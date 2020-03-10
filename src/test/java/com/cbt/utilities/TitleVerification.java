package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) throws InterruptedException {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        BrowserFactory.getDriver("chrome");
        WebDriver driver = new ChromeDriver();
        driver.get(urls.get(0));
        String title1 = driver.getTitle();
        String url1 = driver.getCurrentUrl();

        Thread.sleep(3000);

        driver.get(urls.get(1));
        String title2 = driver.getTitle();
        String url2 = driver.getCurrentUrl();

        Thread.sleep(3000);

        driver.get(urls.get(2));
        String title3 = driver.getTitle();
        String url3 = driver.getCurrentUrl();

        Thread.sleep(3000);

        if (title1.equals(title2) && title2.equals(title3)) {
            System.out.println("have same title");
        } else {
            System.out.println(" have different titles");
            System.out.println(title1);
            System.out.println(title2);
            System.out.println(title3);
        }

        if (url1.startsWith("http://practice.cybertekschool.com")
                && url2.startsWith("http://practice.cybertekschool.com")
                && url3.startsWith("http://practice.cybertekschool.com")) {
            System.out.println("they all start with same url");
        }





        Thread.sleep(3000);


        driver.quit();

    }

}
