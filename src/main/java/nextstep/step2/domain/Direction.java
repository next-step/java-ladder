package nextstep.step2.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1);

    private final int position;

    Direction(int position) {
        this.position = position;
    }

    public int nextPosition() {
        return position;
    }
}
