package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        String host = "localhost";

        DesiredCapabilities dc = new DesiredCapabilities();


        if(System.getProperty("BROWSER") != null &&
        System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc.setBrowserName(Browser.FIREFOX.browserName());
        }else{
            dc.setBrowserName(Browser.CHROME.browserName());
        }
        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }
        String completeUrl= "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);



    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }

}
