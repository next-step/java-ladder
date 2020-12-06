package nextstep.ladder.domain;

public interface DirectionStrategy {

    Direction getStartDirection();

    Direction getNextDirection(Direction direction);

    Direction getEndDirection(Direction direction);
}
