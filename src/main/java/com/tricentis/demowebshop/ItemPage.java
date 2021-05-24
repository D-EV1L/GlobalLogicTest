package com.tricentis.demowebshop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.HoverOptions;
import com.codeborne.selenide.SelenideElement;
import com.tricentis.demowebshop.data.Attributes;

import static com.codeborne.selenide.Selenide.$x;

public class ItemPage {

    private SelenideElement cartLink = $x("//li[@id='topcartlink']/a");
    private SelenideElement itemTitle = $x("//h1");
    private SelenideElement addToCartButton = $x("//input[contains(@id, 'add-to-cart')]");
    private SelenideElement attributes = $x("//div[@class='attributes']/dl");
    private SelenideElement flyoutCart = $x("//div[@id='flyout-cart']");
    private int count = Integer.parseInt(
            cartLink
                    .$x("./span[@class='cart-qty']")
                    .text()
                    .replaceAll("\\D", "")
    );

    public ItemPage customizeDesktop(Attributes processor, Attributes RAM) {
        attributes
                .$x("./dt[contains(.,'Processor')]")
                .$x("./following::dd")
                .$x(".//label[contains(., '" + processor.getAttribute() + "')]")
                .click();
        attributes
                .$x("./dt[contains(.,'RAM')]")
                .$x("./following::dd")
                .$x(".//label[contains(., '" + RAM.getAttribute() + "')]")
                .click();
        return this;
    }

    public ItemPage selectAllSoftware() {
        attributes
                .$x("./dt[contains(.,'Software')]")
                .$x("./following::dd")
                .$$x(".//label")
                .forEach(SelenideElement::click);
        return this;
    }

    public ItemPage validateCartCounter() {
        cartLink.shouldHave(Condition.text("(" + ++count + ")"));
        return this;
    }

    public ItemPage addToCart() {
        addToCartButton.click();
        return this;
    }

    public CartPage goToCart() {
        cartLink.click();
        return new CartPage();
    }
}