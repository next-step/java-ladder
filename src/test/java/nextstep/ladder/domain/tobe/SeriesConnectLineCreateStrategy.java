package nextstep.ladder.domain.tobe;

public class SeriesConnectLineCreateStrategy implements LineCreateStrategy {

    @Override
    public Direction first() {
        return Direction.CENTER;
    }

    @Override
    public Direction body(Direction exDirection) {
        return Direction.LEFT;
    }

    @Override
    public Direction last(Direction exDirection) {
        return Direction.CENTER;
    }
}
