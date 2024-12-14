package nextstep.ladder.domain;

@FunctionalInterface
public interface DirectionOperation {
    boolean getDirection(boolean before, boolean after);
}
