package ladder.domain;

public class Position {
    private static final int INIT_POSITION = 0;
    private static final int MOVE_DISTANCE = 1;

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public static Position first() {
        return new Position(INIT_POSITION);
    }

    public Position increase() {
        return new Position(position + MOVE_DISTANCE);
    }

    public Position decrease() {
        return new Position(position - MOVE_DISTANCE);
    }

    public int getPosition() {
        return position;
    }


}
