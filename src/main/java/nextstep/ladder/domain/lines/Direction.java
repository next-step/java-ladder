package nextstep.ladder.domain.lines;

public enum Direction {

    LEFT(-1), RIGHT(1), MIDDLE(0);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int move(int position) {
        return this.value + position;
    }
}
