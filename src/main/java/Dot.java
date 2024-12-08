public class Dot {
    private final boolean left;
    private final boolean current;

    public Dot(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("cannot be true both of left and current value.");
        }

        this.left = left;
        this.current = current;
    }

    public Dot chain(boolean current) {
        return new Dot(this.current, current);
    }

    public Direction move() {
        if (left && !current) {
            return Direction.LEFT;
        }

        if (!left && current) {
            return Direction.RIGHT;
        }

        return Direction.PASS;
    }

    @Override
    public String toString() {
        return "  o  " + (this.current ? "--" : "  ");
    }
}
