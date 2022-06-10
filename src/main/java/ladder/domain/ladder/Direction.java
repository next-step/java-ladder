package ladder.domain.ladder;

import java.util.Random;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
        System.out.println(this);
    }

    public Direction next() {
        if(right) {
            return new Direction(right, false);
        }
        return new Direction(right, generate());
    }

    public Direction last() {
        return new Direction(this.right, false);
    }

    private static boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }
}
