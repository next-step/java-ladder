package nextstep.ladder.domain;

public class Column {
    private final Direction direction;

    private Column(Direction direction) {
        this.direction = direction;
    }

    public static Column head(boolean right) {
        return new Column(Direction.of(Boolean.FALSE, right));
    }

    public static Column body(boolean left, boolean right) {
        return new Column(Direction.of(left, right));
    }

    public static Column tail(boolean left) {
        return new Column(Direction.of(left, Boolean.FALSE));
    }

    public int move(int index) {
        return direction.move(index);
    }

    public boolean isRight() {
        return direction == Direction.RIGHT;
    }
}
