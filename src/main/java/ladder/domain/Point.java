package ladder.domain;

import java.util.Objects;

public class Point {   
    private boolean left;
    private boolean right;
    
    private Point(boolean left, boolean right) {
        if (left == true && right == true) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public static Point of(boolean left, boolean right) {
        return PointType.findByLeftRight(left, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left &&
                right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    public int nextDirection() {
        if (left) {
            return -1;
        }
        if (right) {
            return 1;
        }
        return 0;
    }

    public boolean canMoveRight() {
        return right;
    }

    public boolean isOverlap(Point previousPoint) {
        return right && previousPoint.right;
    }
    
    
    enum PointType {
        FROMLEFT(true, false, new Point(true, false)),
        TORIGHT(false, true, new Point(false, true)),
        NONE(false, false, new Point(false, false));
        
        private boolean left;
        private boolean right;
        private Point point;
        
        private PointType(boolean left, boolean right, Point point) {
            this.left = left;
            this.right = right;
            this.point = point;
        }

        public static Point findByLeftRight(boolean left, boolean right) {
            for (PointType pointType : PointType.values()) {
                if (pointType.left == left && pointType.right == right) {
                    return pointType.point;
                }
            }
            throw new IllegalArgumentException("지원하지 않는 포인트타입입니다.");
        }
    }
}
