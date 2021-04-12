package ladder.domain.nextstep;

public enum Point {
    LEFT(-1),
    DOWN(0),
    RIGHT(1);

    private final int move;

    Point(int move) {
        this.move = move;
    }

    public static Point randomPoint() {
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

    public static Point last(Point point) {
        if (point.move == 1) {
            return LEFT;
        }
        return DOWN;
    }

    public int move(){
        return move;
    }
}