package nextstep.step2.vo;

import java.util.Objects;

public enum Bridge {
    DOWN(0),
    RIGHT(1),
    LEFT(-1);

    private final int value;

    Bridge(int value) {
        this.value = value;
    }

    public Bridge next(boolean random) {
        if(this.equals(Bridge.RIGHT)) {
            return Bridge.LEFT;
        }

        if(this.equals(Bridge.LEFT)) {
            return Bridge.DOWN;
        }

        if(random) {
            return Bridge.RIGHT;
        }

        return Bridge.DOWN;
    }
}
