package nextstep.ladder.domain;

public interface BooleanStrategy {
    boolean value(boolean value);

    class OnlyTrueStrategy implements BooleanStrategy {
        @Override
        public boolean value(boolean value) {
            return true;
        }
    }
}
