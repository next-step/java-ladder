package step3.strategy;

import step3.Position;

public class NoSideMove implements SideMoveStrategy {
    private final Position position;

    public NoSideMove(Position position) {
        this.position = position;
    }

    @Override
    public Position move() {
        return position.just();
    }
}
