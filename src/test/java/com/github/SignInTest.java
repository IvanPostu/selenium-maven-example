package com.github;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInTest extends WebDriverConfig {

    @Test
    public void invalidSignInTest() {

        final String randomUsername = "AbracadabraAhalaiMahalai1394134";
        final String randomPassword = "qwerty";

        driver.get("https://github.com/login");
        WebElement loginField = driver.findElement(By.name("login"));
        WebElement passwordField = driver.findElement(By.name("password"));

        loginField.sendKeys(randomUsername);
        passwordField.sendKeys(randomPassword);
        passwordField.submit();

        WebElement errorMessageBlock = new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("/html/body/div[3]/main/div/div[2]/div/div")));

        String errorMessageText = errorMessageBlock.getText();

        Assertions.assertEquals("Incorrect username or password.", errorMessageText);

    }

}
