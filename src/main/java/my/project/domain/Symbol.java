package my.project.domain;

public enum Symbol {
    VERTICAL("|"),
    BRIDGE("-----"),
    NONE("     ");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
