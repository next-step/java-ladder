package nextstep.ladder.domain.tobe;

public class FixedLineCreateStrategy implements LineCreateStrategy {

    @Override
    public Direction first() {
        return Direction.CENTER;
    }

    @Override
    public Direction body() {
        return Direction.CENTER;
    }

    @Override
    public Direction last() {
        return Direction.CENTER;
    }
}
