package com.tricentis.demowebshop.data;

public enum PageSize {

    FOUR(4),
    EIGHT(8),
    TWELVE(12);

    private final Integer itemsCount;

    PageSize(Integer size) {
        this.itemsCount = size;
    }

    public Integer getSize() {
        return itemsCount;
    }
}