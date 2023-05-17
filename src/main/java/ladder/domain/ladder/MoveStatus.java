package ladder.domain.ladder;

public enum MoveStatus {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int move;

    MoveStatus(int move) {
        this.move = move;
    }
}
