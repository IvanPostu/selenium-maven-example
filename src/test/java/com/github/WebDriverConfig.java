package com.github;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverConfig {
    private static ChromeDriverService service;
    protected WebDriver driver;

    @BeforeAll
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder().usingDriverExecutable(new File("chromedriver"))
                .usingAnyFreePort().build();

        service.start();
    }

    @BeforeEach
    public void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
    }



    @AfterEach
    public void quitDriver() {
        driver.quit();
    }



    @AfterAll
    public static void createAndStopService() {
        service.stop();
    }
}
