package domain;

import java.util.stream.Stream;

interface Operation {
    int move(int position);
}

public enum DirectionType implements Operation {
    LEFT(Movable.TRUE, Movable.FALSE) {
        @Override
        public int move(int position) {
            return position - 1;
        }
    },
    NONE(Movable.FALSE, Movable.FALSE) {
        @Override
        public int move(int position) {
            return position;
        }
    },
    RIGHT(Movable.FALSE, Movable.TRUE) {
        @Override
        public int move(int position) {
            return position + 1;
        }
    };

    private Movable left;
    private Movable right;

    DirectionType(Movable left, Movable right) {
        if (left.on() && right.on()) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.right = right;
    }

    public static DirectionType valueOf(Movable left, Movable right) {
        return Stream.of(DirectionType.values())
                .filter(directionType -> directionType.left == left && directionType.right == right)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static DirectionType first(Movable next) {
        return valueOf(Movable.FALSE, next);
    }

    public DirectionType last() {
        return valueOf(right, Movable.FALSE);
    }

    public DirectionType next(Movable next) {
        return valueOf(right, next);
    }


    @Override
    public String toString() {
        return "DirectionType{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
