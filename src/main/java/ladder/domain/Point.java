package ladder.domain;

public enum Point {
    LEFT(-1, "--|"),
    DOWN(0, "     |"),
    RIGHT(1, "     |---");

    private final int move;
    private final String view;

    Point(int move, String view) {
        this.move = move;
        this.view = view;
    }

    private static Point randomPoint() {
        if(RandomGenerator.randomInt() == 1){
            return RIGHT;
        }
        return DOWN;
    }

    public static Point next(Point point) {
        if (point.move == 1) {
            return LEFT;
        }
        return randomPoint();
    }

    @Override
    public String toString() {
        return view;
    }
}