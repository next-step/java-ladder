package nextstep.ladder.domain.tobe;

public class RightConnectLineCreateStrategy implements LineCreateStrategy {

    @Override
    public Direction first() {
        return Direction.RIGHT;
    }

    @Override
    public Direction body(Direction exDirection) {
        return Direction.RIGHT;
    }

    @Override
    public Direction last(Direction exDirection) {
        return Direction.RIGHT;
    }
}
