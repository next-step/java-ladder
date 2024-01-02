package nextstep.ladder.domain.strategy;

public interface PositionMovableStrategy {

    boolean isLeftMovements();

    boolean isRightMovements();

    int move();
}
