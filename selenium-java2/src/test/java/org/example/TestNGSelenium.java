package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    @Test
    public void testDatePicker(){
        System.out.println("testDatePicker");
        openURL("https://demoqa.com/date-picker");

        WebElement datePicker = driver.findElement(By.id("datePickerMonthYearInput"));
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDateTime dateNow = LocalDateTime.now();

        System.out.println(dateFormat.format(dateNow));
        Assert.assertEquals(datePicker.getAttribute("value"), dateFormat.format(dateNow));

        datePicker.click();
        datePicker.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));

        datePicker.sendKeys("01/01/2023");
        Assert.assertEquals(datePicker.getAttribute("value"), "01/01/2023");
    }

}
