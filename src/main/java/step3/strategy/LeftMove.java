package step3.strategy;

import step3.Position;

public class LeftMove implements SideMoveStrategy {
    private final Position position;

    public LeftMove(Position position) {
        this.position = position;
    }

    @Override
    public Position getMove() {
        return position.toLeft();
    }
}
