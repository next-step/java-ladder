package nextstep.ladder.domain;

public enum Direction {
    LEFT(-1), DOWN(0), RIGHT(1),
    ;

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int move(int position) {
        return position + direction;
    }
}
