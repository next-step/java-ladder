package ladder.domain.ladder;

public enum Cross {
    CROSS,
    NOT_CROSS;

    boolean isCross() {
        return (CROSS == this);
    }
}
