package com.hskim.ladder.model;

public enum Point {
    BLANK(5),
    COLUMN(1),
    ROW(5);

    private final int width;

    Point(int width) {
        this.width = width;
    }

    public String getPrintString(String symbol) {
        return new String(new char[width]).replace("\0", symbol);
    }
}
