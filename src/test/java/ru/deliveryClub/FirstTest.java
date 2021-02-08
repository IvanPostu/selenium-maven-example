package ru.deliveryClub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    @Test
    public void titleWebsiteTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.delivery-club.ru/");
        final String expectedWebsiteTitle =
                "Delivery Club — Доставка еды из ресторанов от 25 минут!";

        String websiteTitle = driver.getTitle();

        Assertions.assertEquals(expectedWebsiteTitle, websiteTitle);

        driver.quit();
    }

}
