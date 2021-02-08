package com.github;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RootPageTest extends WebDriverConfig {


    @Test
    public void testGithubTitle() {

        driver.get("https://github.com/");
        final String expectedWebsiteTitle = "GitHub: Where the world builds software · GitHub";

        String websiteTitle = driver.getTitle();

        Assertions.assertEquals(expectedWebsiteTitle, websiteTitle);
    }

}
