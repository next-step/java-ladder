package ladder.domain.enums;

import java.util.Arrays;
import java.util.Random;

public enum Direction {
    LEFT(-1),
    NONE(0),
    RIGHT(1);

    private final int value;
    private static Random random = new Random();

    Direction(int value) {
        this.value = value;
    }

//    public static Direction of(int number) {
//        return Arrays.stream(Direction.values())
//                .filter(direction -> direction.value == number)
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException(
//                        "유효하지 않은 Direction 값이 입력되었습니다. (입력값 : " + number + ")"));
//    }

    public int getValue() {
        return value;
    }

//    public static Direction getRightOrNone() {
////        return of(random.nextInt(RIGHT.value + 1));
//        if (random.nextBoolean()) {
//            return RIGHT;
//        }
//        return NONE;
//    }
//
//    public static Direction getLeftOrNone() {
//        if (random.nextBoolean()) {
//            return LEFT;
//        }
//        return NONE;
//    }
}
