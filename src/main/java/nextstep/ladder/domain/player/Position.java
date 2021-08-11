package nextstep.ladder.domain.player;

public class Position {
    private int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position from(final int position) {
        return new Position(position);
    }

    public Position moveLeft() {
        --position;
        return this;
    }

    public Position moveRight() {
        ++position;
        return this;
    }

    public int currentPosition() {
        return position;
    }
}
