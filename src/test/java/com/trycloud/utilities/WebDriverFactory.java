package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType) {
        browserType = browserType.toLowerCase();
        if (browserType.contains("chrome")) {

            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if (browserType.contains("safari")) {

            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        } else {

            System.out.println("Enter a valid browser type. Drive = null!");
            return null;

        }
    }

}
