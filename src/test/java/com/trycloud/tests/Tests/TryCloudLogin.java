package com.trycloud.tests.Tests;

import com.trycloud.utilities.BrowserUtils;
import org.testng.annotations.Test;

public class TryCloudLogin extends TestBase {
    @Test
    public void verifyLoginTest() throws InterruptedException, IOException {
        //#1- Create Properties class object
        Properties properties = new Properties();

        //#2- Open the file in JVM Memory and pass the path of the file
        String path = "configuration.properties";
        //For windows > copy path > copy path from content root

        FileInputStream file = new FileInputStream(path);

        //#3- Load the opened file into the Properties object.

        properties.load(file);

        String url = properties.getProperty("tryCloudUrl");

        driver.get(url);

        TryCloudUtils.validLoginToTryCloud(driver);

        //This is re-usable method we created in BrowserUtil class to replace Thread.sleep
        BrowserUtils.sleep(1);

        TryCloudUtils.verifyValidLoginUrl(driver, "http://app.trycloud.net/index.php/apps/files/?dir=/&fileid=82309");

    }
    @Test
    public void verifyInvalidLoginTest() throws InterruptedException, IOException {
        //#1- Create Properties class object
        Properties properties = new Properties();

        //#2- Open the file in JVM Memory and pass the path of the file
        String path = "configuration.properties";
        //For windows > copy path > copy path from content root

        FileInputStream file = new FileInputStream(path);

        //#3- Load the opened file into the Properties object.
        properties.load(file);

        String url = properties.getProperty("tryCloudUrl");

        driver.get(url);

        TryCloudUtils.inValidLoginToTryCloud(driver);

        //This is re-usable method we created in BrowserUtil class to replace Thread.sleep
        BrowserUtils.sleep(1);
        TryCloudUtils.verifyInvalidLoginUrl(driver, "http://app.trycloud.net/index.php/login?user=User0");

    }


}
