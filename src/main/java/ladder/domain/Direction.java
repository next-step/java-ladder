package ladder.domain;

public class Direction {

    public static int goLeft(boolean left, int location) {
        return left ? location - 1 : location;
    }

    public static int goRight(boolean right, int location) {
        return right ? location + 1 : location;
    }
}
