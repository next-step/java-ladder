package ladder_v2.domain;

import java.util.Random;

public class Point {

    private final boolean left;
    private final boolean right;
    private static final Random random = new Random();

    private Point(boolean left, boolean right) {
        if(left && right){
            throw new IllegalArgumentException("Point는 left, right 둘 중 하나만 true여야 합니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Point of(boolean left, boolean right){
        return PointCache.getPoint(left, right);
    }

    public boolean isRight() {
        return right;
    }

    public static Point first() {
        return Point.of(false, random.nextBoolean());
    }

    public Point middle() {
        boolean isTrue = random.nextBoolean();
        if (isRight()) {
            return Point.of(this.right, false);
        }
        return Point.of(this.right, isTrue);
    }

    public Point last() {
        return Point.of(right, false);
    }

    public Direction move(){
        if (this.right) {
            return Direction.RIGHT;
        }
        if (this.left) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    static class PointCache{
        private static final Point[] points = new Point[3];

        static {
            points[0] = new Point(false, true);
            points[1] = new Point(true, false);
            points[2] = new Point(false, false);
        }

        public static Point getPoint(boolean left, boolean right){
            if(right){
                return points[0];
            }
            if(left){
                return points[1];
            }
            return points[2];
        }
    }
}
