package com.github;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotFoundPageTest extends WebDriverConfig {


    @Test
    public void notFound404PageTest() {
        driver.get("https://github.com/adfhjadhkfdhakfadhkfahdkfadf__SOdpaoio31iorp");
        String websiteTitle = driver.getTitle();

        Assertions.assertEquals("Page not found · GitHub · GitHub", websiteTitle);
    }
}
