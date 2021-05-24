package com.tricentis.demowebshop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement topMenu = $x("//ul[@class='top-menu']");

    public CategoryPage openCategory(String category) {
        topMenu
                .$x("./li[contains(.,'" + category + "')]")
                .click();
        return new CategoryPage();
    }

    public CategoryPage openCategory(String category, String subcategory) {
        topMenu
                .$x("./li[contains(.,'" + category + "')]")
                .hover()
                .$x(".//ul/li[contains(.,'" + subcategory + "')]")
                .click();
        return new CategoryPage();
    }
}