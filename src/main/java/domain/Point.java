package domain;

public class Point {

    private static final String EXIST = "-----|";
    private static final String NOT_EXIST = "     |";

    private final boolean exist;

    public Point(boolean exist) {
        this.exist = exist;
    }

    public static Point of(Point prev, boolean exist) {
        if (prev.isExists()) {
            return new Point(false);
        }

        return new Point(exist);
    }

    public static Point first() {
        return new Point(false);
    }

    public boolean isExists() {
        return exist;
    }

    @Override
    public String toString() {
        if (this.exist) {
            return EXIST;
        }

        return NOT_EXIST;
    }
}
