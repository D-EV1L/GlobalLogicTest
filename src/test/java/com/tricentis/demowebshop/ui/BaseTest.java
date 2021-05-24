package com.tricentis.demowebshop.ui;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setup() {
        Configuration.baseUrl = "https://demowebshop.tricentis.com";
        Configuration.startMaximized = true;
        Configuration.browser = Browsers.CHROME;
        Selenide.open("");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}