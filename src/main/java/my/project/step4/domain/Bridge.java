package my.project.step4.domain;

public enum Bridge {
    CONNECTED(true, "-----"),
    NONE(false, "     "),
    VERTICAL(false, "|");

    private final boolean bool;
    private final String symbol;

    Bridge(boolean bool, String symbol) {
        this.bool = bool;
        this.symbol = symbol;
    }

    public boolean value() {
        return this.bool;
    }

    public String getSymbol() {
        return symbol;
    }
}
