public class Pos {
    private static final int INVALID_X = -1;
    private static final int INVALID_Y = -1;

    private final int x;
    private final int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean xIs(int x) {
        return this.x == x;
    }

    public boolean yIs(int y) {
        return this.y == y;
    }

    public static Pos invalid() {
        return new Pos(INVALID_X, INVALID_Y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos that = (Pos) o;

        if (this.x == INVALID_X || this.y == INVALID_Y || that.x == INVALID_X || that.y == INVALID_Y) {
            return false;
        }

        return x == that.x && y == that.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int getX() {
        return this.x;
    }
}
