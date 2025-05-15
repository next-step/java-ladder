package nextstep.ladder2.domain.ladder;

public enum Direction {
    LEFT (-1),
    RIGHT (+1),
    PASS (0);

    private final int value;

    Direction(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
