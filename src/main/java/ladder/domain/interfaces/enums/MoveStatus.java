package ladder.domain.interfaces.enums;

public enum MoveStatus {
    LEFT(-1),
    STOP(0),
    RIGHT(1)
    ;
    MoveStatus(int value) {
        this.value = value;
    }
    private final int value;

    public int value() {
        return value;
    }
}
