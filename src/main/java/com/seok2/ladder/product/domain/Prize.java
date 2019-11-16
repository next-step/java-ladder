package com.seok2.ladder.product.domain;

public class Prize {

    private final String name;

    private Prize(String name) {
        this.name = name;
    }

    public static Prize of(String name) {
        return new Prize(name);
    }

    public String getName() {
        return name;
    }

}
