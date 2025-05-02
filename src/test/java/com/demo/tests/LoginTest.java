package com.demo.tests;

import com.demo.BaseTest;
import com.demo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        // System.out.println("Page title: " + driver.getTitle());
        // System.out.println("Page body: " + driver.findElement(By.tagName("body")).getText());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student", "Password123");

        // System.out.println("Fetched Success Message: " + message);
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Full Page Body: " + driver.findElement(By.tagName("body")).getText());
        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Page Body After Login:\n" + bodyText);

        String message = loginPage.getSuccessMessage();
        Assert.assertTrue(message.contains("Congratulations student. You successfully logged in!"), "Login failed!");
    }
}
