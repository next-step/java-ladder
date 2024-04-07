package nextstep.ladder.domain.line;

public enum MoveDirection {
    NO_MOVE(0),
    LEFT(-1),
    RIGHT(1);

    private final int value;

    MoveDirection(int value) {
        this.value = value;
    }

    public int move(int currentIndex){
        return value + currentIndex;
    }
}
