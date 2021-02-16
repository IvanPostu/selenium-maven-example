package com.github;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RootPageTest extends WebDriverConfig {


    @Test
    public void githubTitleTest() {

        driver.get("https://github.com/");
        final String expectedWebsiteTitle = "GitHub: Where the world builds software · GitHub";

        String websiteTitle = driver.getTitle();

        Assertions.assertEquals(expectedWebsiteTitle, websiteTitle);
    }

    @Test
    public void githubMenuIsShowedOnHoverTest() throws InterruptedException {
        driver.get("https://github.com/");
        WebElement menuHoverableButton = driver
                .findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[1]/details"));



        Actions action = new Actions(driver);
        action.moveToElement(menuHoverableButton).perform();

        WebElement teamListElement =
                driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[2]"));

        action.moveToElement(teamListElement).perform();
        action.moveToElement(menuHoverableButton).perform();

        Assertions.assertNotNull(menuHoverableButton.getAttribute("open"));
    }

    @Test
    public void allNavbarDropdownMenuIsShowedOnHover() {
        driver.get("https://github.com/");
        WebElement navbarElement =
                driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul"));

        List<WebElement> dropdownListItems = navbarElement.findElements(By
                .xpath("//li[contains(@class, 'd-lg-flex flex-lg-nowrap flex-lg-items-center')]"));


        WebElement teamListElement =
                driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[2]"));
        for (WebElement dropdownListItem : dropdownListItems) {
            WebElement dropdownHoverable = dropdownListItem.findElement(By.tagName("details"));
            Actions action = new Actions(driver);
            action.moveToElement(dropdownHoverable).perform();
            action.moveToElement(teamListElement).perform();
            action.moveToElement(dropdownHoverable).perform();

            Assertions.assertNotNull(dropdownHoverable.getAttribute("open"));
        }
    }

}
