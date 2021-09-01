package newladder.model;

public class Point {
    final boolean left;
    final boolean right;

    public Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    // 첫번째의 왼쪽은 무조건 false
    public static Point first(boolean right) {
        return new Point(false, right);
    }

    // 마지막의 오른쪽은 무조건 false
    public Point last() {
        return new Point(this.right, false);
    }

    public Point nextPoint(boolean next) {
        if (this.right) {
            return new Point(this.right, false);
        }
        return new Point(this.right, next);
    }
}
