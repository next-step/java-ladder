package com.hskim.ladder.model;

public enum LadderPoint {
    BLANK(5),
    COLUMN(1),
    ROW(5);

    private final int width;

    LadderPoint(int width) {
        this.width = width;
    }

    public String getPrintString(String symbol) {
        return new String(new char[width]).replace("\0", symbol);
    }
}
