package com.tricentis.demowebshop;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.tricentis.demowebshop.data.PageSize;
import com.tricentis.demowebshop.data.Sort;

import static com.codeborne.selenide.Selenide.$x;

public class CategoryPage {

    private SelenideElement displayItemsPerPage = $x("//select[@id='products-pagesize']");
    private SelenideElement sort = $x("//select[@id='products-orderby']");
    private SelenideElement itemsList = $x("//div[@class='product-grid']");


    public CategoryPage setPageSize(PageSize size) {
        displayItemsPerPage.click();
        displayItemsPerPage.selectOption(size.getSize().toString());
        itemsList.$$x("./div[@class='item-box']").shouldHave(CollectionCondition.size(size.getSize()));
        return this;
    }

    public CategoryPage sortItems(Sort sortMethod) {
        sort.click();
        sort.selectOption(sortMethod.getMethod());
        return this;
    }

    public ItemPage chooseMostExpensiveItem() {
        itemsList.$x("./div[@class='item-box'][1]").click();
        return new ItemPage();
    }
}