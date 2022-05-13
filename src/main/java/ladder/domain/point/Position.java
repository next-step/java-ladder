package ladder.domain.point;

public class Position {
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public static Position value(int position) {
        return new Position(position);
    }
}
