package dto;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

/**
 * 이전값의 영향을 받아서 다음 값이 정해진다....흠
 *
 */
public enum Direction {

    BOTTOM(false,false),
    RIGHT(false,true),
    LEFT(true,false),
    ERROR(true,true);

    private boolean left;
    private boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public static Direction find(boolean left, boolean right) {
        for (Direction d : Direction.values()){
            if(d.isLeft() == left && d.isRight() == right)
                return d;
        }
        return Direction.ERROR;
    }

    public static Direction next(boolean right) {
        if(right) {
            return Direction.find(right, Boolean.FALSE);
        }
        return Direction.find(right,new Random().nextBoolean());
    }
}
