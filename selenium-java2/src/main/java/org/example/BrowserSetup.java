package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BrowserSetup {

    WebDriver driver;
    String URL = "https://demoqa.com/elements";

    @BeforeSuite()
    public void beforeSuite() {
        System.out.println(" > BeforeSuite < ");
        browserSetUp();
    }
    @AfterSuite()
    public void afterSuite() {
        System.out.println(" > AfterSuite < ");
        quitBrowser();
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println(" > BeforeTest < ");
    }
    @AfterTest
    public void afterTest() {
        System.out.println(" > AfterTest < ");
    }
    @BeforeGroups
    public void beforeGroups() {
        System.out.println(" > BeforeGroups < ");
    }
    @AfterGroups
    public void afterGroups() {
        System.out.println(" > AfterGroups < ");
    }

    @BeforeMethod()
    public void beforeMethod(){
        System.out.println(" > BeforeMethod <");
        openURL(URL);
    }

    @AfterMethod()
    public void afterMethod(){
        System.out.println(" > AfterMethod <");
        wait(1000);
    }

    public void quitBrowser() {
        log("Closing Chrome browser.");
        driver.quit();
    }

    public void openURL(String url) {
        log("Opening URL: " + url);
        driver.get(url);
    }

    public static void log(String text) {
        System.out.println(text);
    }

    public static void wait(int millis) {
        log(String.format("Waiting for %d millis.", millis));

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void browserSetUp() {
        log("Setting up Chrome browser.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

}
