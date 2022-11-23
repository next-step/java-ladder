package ladder.domain;

public enum Direction {

    LEFT {
        @Override
        public Point move(final PositiveInt x) {
            validate(x);
            return new Point(x.plus(-1));
        }
    },
    STRAIGHT {
        @Override
        public Point move(final PositiveInt x) {
            validate(x);
            return new Point(x);
        }
    },
    RIGHT {
        @Override
        public Point move(final PositiveInt x) {
            validate(x);
            return new Point(x.plus(1));
        }
    };

    public abstract Point move(final PositiveInt x);

    Direction() {
    }

    private static void validate(final PositiveInt x) {
        if (x == null) {
            throw new IllegalArgumentException("입력 값이 누락되었습니다.");
        }
    }
}
