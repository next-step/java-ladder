package step3.strategy;

import step3.Position;

public class RightMove implements SideMoveStrategy {
    @Override
    public Position sideMove(Position position) {
        return position.toRight();
    }
}
