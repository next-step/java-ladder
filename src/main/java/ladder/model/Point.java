package ladder.model;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("Point는 양방향으로 연결할 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }
}
