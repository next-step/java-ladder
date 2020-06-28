package ladder.domain.result;

public enum Movement {
    LEFT(-1),
    GO(0),
    RIGHT(+1);

    private int position;

    Movement(int position) {
        this.position = position;
    }

    public int move(int position) {
        return position + this.position;
    }

    public static Movement valueBy(boolean left, boolean right) {
        if (left && !right) {
            return LEFT;
        }

        if (!left && right) {
            return RIGHT;
        }

        return GO;
    }
}
