package ladder.domain;

public enum BarType {

    LEFT("-----|"),
    NONE("     |");

    private final String bar;

    BarType(String bar) {
        this.bar = bar;
    }

    public static BarType of(boolean pointType) {
        if (pointType) {
            return BarType.LEFT;
        }
        return BarType.NONE;
    }

    public String getBar() {
        return bar;
    }
}
