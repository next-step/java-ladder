package step04.model;

public enum Point {

    ROW("-", 5),
    COLUMN("|", 1),
    BLANK(" ", 5);

    private final String symbol;
    private final int width;

    Point(String symbol, int width) {
        this.symbol = symbol;
        this.width = width;
    }

    public String getPrintableString() {
        return new String(new char[width]).replace("\0", symbol);
    }
}
