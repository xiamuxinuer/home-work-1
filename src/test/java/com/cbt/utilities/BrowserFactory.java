package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().version("79").setup();
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FirefoxDriver")) {
            WebDriverManager.firefoxdriver().version("79").setup();
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("EdgeDriver")) {
            WebDriverManager.edgedriver().version("79").setup();
            return new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari"))
            return null;
        else return null;
    }

}








