package nextstep.step4.responsibility.domain;

public enum Mover implements IndexHorizontalMover {
    LEFT {
        @Override
        public int moveHorizontal(final int index) {
            return index - 1;
        }
    },
    NONE {
        @Override
        public int moveHorizontal(final int index) {
            return index;
        }
    },
    RIGHT {
        @Override
        public int moveHorizontal(final int index) {
            return index + 1;
        }
    };

    public static Mover first(final boolean curBool) {
        if (curBool) {
            return RIGHT;
        }

        return NONE;
    }

    public Mover next(final boolean curBool) {
        if (this == RIGHT) {
            return LEFT;
        }

        if (curBool) {
            return RIGHT;
        }

        return NONE;
    }

    public Mover last() {
        if (this == RIGHT) {
            return LEFT;
        }

        return NONE;
    }
}
