package step2.model;

import java.util.Arrays;

public enum Movement {
    LEFT(-1),
    RIGHT(1),
    NONE(0);
    private final int direction;

    Movement(int direction) {
        this.direction = direction;
    }

    public static Movement valueOf(int value) {
        return Arrays.stream(Movement.values())
                .filter(it -> it.getDirection() == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                ;
    }

    public int getDirection() {
        return this.direction;
    }


}
