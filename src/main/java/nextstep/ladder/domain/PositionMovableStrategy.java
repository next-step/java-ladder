package nextstep.ladder.domain;

public interface PositionMovableStrategy {

    boolean isLeftMovements();

    boolean isRightMovements();

    int move();
}
