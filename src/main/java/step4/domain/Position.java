package step4.domain;

public class Position {
    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position valueOf(int number) {
        return new Position(number);
    }
}
