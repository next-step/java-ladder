package step3.strategy;

import step3.Position;

public class NoMove implements SideMoveStrategy {
    @Override
    public Position sideMove(Position position) {
        return position.just();
    }
}
