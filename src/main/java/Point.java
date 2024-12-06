public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int calcAddX(int n) {
        return this.x + n;
    }

    public int calcDivX(int n) {
        return this.x / n;
    }

    public int calcAddY(int n) {
        return this.y + n;
    }

    public boolean xIs(int n) {
        return this.x == n;
    }

    public boolean yIsLowerThan(int y) {
        return this.y < y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;

        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return this.x * 1_000 + this.y;
    }
}
