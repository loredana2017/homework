package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGSelenium extends BrowserSetup {

    int a = 5;
    int b = 5;
    int sum = 10;
    String text = "I have two apples.";
    String wordToTest = "apple";

    @Test(description = "Test_S1", groups = "selenium-tests")
    public void testPageTitle1() {
        System.out.println("Test_S1 header 1");
        WebElement header = driver.findElement(By.xpath("//*[@class='main-header']"));
        Assert.assertEquals(header.getText(), "Elements", "Wrong text found in header");
    }

    @Test(description = "Test_S2", groups = "selenium-test")
    public void testPageTitle2() {
        System.out.println("Test_S2 header 2");
        WebElement header = driver.findElement(By.xpath("//*[@class='main-header']"));
        Assert.assertEquals(header.getText(), "Elements");
    }

}
