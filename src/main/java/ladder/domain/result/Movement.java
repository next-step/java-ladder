package ladder.domain.result;

public enum Movement {
    LEFT(-1),
    GO(0),
    RIGHT(+1);

    private int position;

    Movement(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public static Movement valueBy(boolean left, boolean right) {
        if (left && !right) {
            return LEFT;
        } else if (!left && right) {
            return RIGHT;
        }

        return GO;
    }
}
