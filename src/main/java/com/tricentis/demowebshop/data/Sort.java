package com.tricentis.demowebshop.data;

public enum Sort {

    POSITION("Position"),
    NAME_A_TO_Z("Name: A to Z"),
    NAME_Z_TO_A("Name: Z to A"),
    PRICE_LOW_TO_HIGH("Price: Low to High"),
    PRICE_HIGH_TO_LOW("Price: High to Low"),
    CREATED_ON("Created on");

    private final String method;

    Sort(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}