package com.tricentis.demowebshop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    private SelenideElement item = $x("//tr[@class='cart-item-row'][contains(., 'Processor: Fast')]");
    private SelenideElement removeCheckbox = item.$x(".//input[@name='removefromcart']");
    private SelenideElement updateCartButton = $x("//input[@name='updatecart']");

    public CartPage itemIsInCartVerification(String price) {
        item
                .$x("./td[contains(@class, 'unit-price')]")
                .shouldHave(Condition.text(price));
        return this;
    }

    public CartPage removeItem() {
        removeCheckbox.click();
        updateCartButton.click();
        return this;
    }
}