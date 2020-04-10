package ladder.domain.type;

import ladder.domain.PointGenerator;
import lombok.Getter;

public enum DirectionType {
    RIGHT(1),
    LEFT(-1),
    DOWN(0);

    @Getter
    private int move;

    DirectionType(int move) {
        this.move = move;
    }

    public static DirectionType first(boolean right) {
        if (right) {
            return RIGHT;
        }

        return DOWN;
    }

    public DirectionType last() {
        if (this == RIGHT) {
            return LEFT;
        }

        return DOWN;
    }

    public DirectionType next() {
        if (this == RIGHT)
            return LEFT;

        return next(PointGenerator.generateDirection());
    }

    private DirectionType next(boolean right) {
        if (right) {
            return RIGHT;
        }

        return DOWN;
    }
}
