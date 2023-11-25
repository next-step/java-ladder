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
    }
}
