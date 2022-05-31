package ladder.constant;

public enum Type {
    FIXED,
    UNFIXED;

    public boolean fixed() {
        return this == FIXED;
    }
}
