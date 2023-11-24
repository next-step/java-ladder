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

    public boolean isRight() {
        return right;
    }

    public static Point first() {
        return new Point(false, random.nextBoolean());
    }

    public Point middle() {
        boolean isTrue = random.nextBoolean();
        if (isRight()) {
            return new Point(this.right, false);
        }
        return new Point(this.right, isTrue);
    }

    public Point last() {
        return new Point(right, false);
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


}
