package nextstep.ladder.domain.ladder;

public enum Direction {
    LEFT {
        @Override
        public Index move(Index index) {
            return index.decrement();
        }
    },
    RIGHT {
        @Override
        public Index move(Index index) {
            return index.increment();
        }
    },
    PASS {
        @Override
        public Index move(Index index) {
            return index;
        }
    };

    public abstract Index move(Index index);
} 