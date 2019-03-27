package ladder.domain.ladder;

public enum Point {
    CROSS,
    NOT_CROSS;

    @Override
    public String toString() {
        return ((CROSS == this) ? "-----" : "     ");
    }
}
