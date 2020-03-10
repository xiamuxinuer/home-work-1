package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) throws InterruptedException {

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
                "https://wayfair.com/",
                "https://walmart.com, ",
                "https://westelm.com/");

        WebDriver driver=BrowserFactory.getDriver("Chrome");

        for (String eachUrl:urls){
            driver.get(eachUrl);
            Thread.sleep(2000);

            if (driver.getCurrentUrl().toLowerCase().contains(driver.getTitle().toLowerCase().replace(" ",""))){
                System.out.println(driver.getTitle());
                System.out.println(driver.getCurrentUrl());
                System.out.println("true");
            }
            else {
                System.out.println(driver.getTitle());
                System.out.println(driver.getCurrentUrl());
                System.out.println("false");


                Thread.sleep(2000);
            }
        }












        Thread.sleep(3000);


        driver.quit();

    }
}
