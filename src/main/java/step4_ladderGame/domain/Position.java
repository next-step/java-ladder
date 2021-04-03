package step4_ladderGame.domain;

public class Position {

    private final int position;

    private Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("포지션은 0이상이여야 합니다.");
        }
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public int toInt() {
        return position;
    }
}
