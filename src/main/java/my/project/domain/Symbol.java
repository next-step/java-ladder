package my.project.domain;

public enum Symbol {
    VERTICAL(1, "|"),
    BRIDGE(2, "-----"),
    NONE(0, "     ");

    private final int number;
    private final String symbol;

    Symbol(int number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }
}
