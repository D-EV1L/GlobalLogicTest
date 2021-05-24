package com.tricentis.demowebshop.ui;

import com.tricentis.demowebshop.ItemPage;
import com.tricentis.demowebshop.MainPage;
import com.tricentis.demowebshop.data.Attributes;
import com.tricentis.demowebshop.data.PageSize;
import com.tricentis.demowebshop.data.Sort;
import org.testng.annotations.Test;

public class UITest extends BaseTest {

    private ItemPage itemPage;

    @Test
    public void testA() {
        itemPage = new MainPage()
                .openCategory("Computers", "Desktops")
                .setPageSize(PageSize.FOUR)
                .sortItems(Sort.PRICE_HIGH_TO_LOW)
                .chooseMostExpensiveItem()
                .addToCart()
                .validateCartCounter();
    }

    @Test
    public void testB() {
        itemPage
                .customizeDesktop(Attributes.FAST, Attributes.GB_8)
                .selectAllSoftware()
                .addToCart()
                .validateCartCounter()
                .goToCart()
                .itemIsInCartVerification("2105.00")
                .removeItem();
    }
}