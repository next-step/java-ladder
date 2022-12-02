package nextstep.ladder.domain;

public enum Direction {
    DOWN(0),
    RIGHT(1),
    LEFT(-1);

    private final int weight;

    Direction(final int weight) {
        this.weight = weight;
    }

    public int movePosition(final int position) {
        return position + this.weight;
    }
}
