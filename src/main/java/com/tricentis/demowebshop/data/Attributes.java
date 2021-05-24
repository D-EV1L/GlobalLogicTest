package com.tricentis.demowebshop.data;

public enum Attributes {

    SLOW("Slow"),
    MEDIUM("Medium"),
    FAST("Fast"),
    GB_2("2GB"),
    GB_4("4GB"),
    GB_8("8GB");

    private final String attribute;


    Attributes(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
