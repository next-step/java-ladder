package ladder.domain;

public class Position {
    private static final int INIT_POSITION = 0;
    private static final int MOVE_DISTANCE = 1;

    private static int position;

    public Position(int position) {
        this.position = position;
    }

    public static Position increase() {
        return new Position(position + MOVE_DISTANCE);
    }

    public static Position decrease() {
        return new Position(position - MOVE_DISTANCE);
    }

    public int getPosition() {
        return position;
    }

    public static Position first() {
        return new Position(INIT_POSITION);
    }

}
