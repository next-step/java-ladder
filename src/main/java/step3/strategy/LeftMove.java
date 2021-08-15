package step3.strategy;

import step3.Position;

public class LeftMove implements SideMoveStrategy {
    @Override
    public Position sideMove(Position position) {
        return position.toLeft();
    }
}
