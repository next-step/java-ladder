package my.project.step3.domain;

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
