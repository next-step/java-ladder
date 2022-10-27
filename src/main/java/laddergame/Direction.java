package laddergame;

import java.util.Random;

public class Direction {
    private static final Random RANDOM = new Random();

    private final boolean left;

    private Direction(boolean left) {
        this.left = left;
    }

    public static Direction random(){
        return new Direction(RANDOM.nextBoolean());
    }

    public boolean isLeft(){
        return left;
    }

    public boolean isRight(){
        return !left;
    }


}
