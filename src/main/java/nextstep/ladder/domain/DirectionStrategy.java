package nextstep.ladder.domain;

public interface DirectionStrategy {

    Direction getStartDirection();

    Direction getNextDirection();

    Direction getEndDirection();
}
