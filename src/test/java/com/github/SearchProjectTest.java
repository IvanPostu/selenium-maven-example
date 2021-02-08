package com.github;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProjectTest extends WebDriverConfig {

    @Test
    public void searchLinuxProjectTest() {
        driver.get("https://github.com/");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("linux");
        element.submit();

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.className("codesearch-results")));

        WebElement linuxBlock = driver
                .findElement(By.xpath("/html/body/div[4]/main/div/div[3]/div/div[1]/div/div[1]"));

        String title = linuxBlock.findElement(By.xpath("//h3[contains(@class, 'mb-1')]")).getText();
        String description = linuxBlock.findElement(By.tagName("p")).getText();

        Assertions.assertEquals("Linux is an open source kernel.", description);
        Assertions.assertEquals("Linux", title);

    }


    @Test
    public void searchUnexistedProjectsTest() {
        driver.get("https://github.com/");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("asdjvhjasdvlhasdlv4134ZZ");
        element.submit();

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.className("codesearch-results")));

        WebElement resultContent = driver.findElement(By.xpath(
                "//html/body/div[4]/main/div/div[3]/div/div[1][contains(@class, 'blankslate')]"));

        String messageFromPage = resultContent.findElement(By.tagName("h3")).getText();
        String expectedEmptyListMessage =
                "We couldn’t find any repositories matching 'asdjvhjasdvlhasdlv4134ZZ'";

        Assertions.assertEquals(expectedEmptyListMessage, messageFromPage);

    }

}
