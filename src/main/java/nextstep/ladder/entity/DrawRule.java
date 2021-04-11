package nextstep.ladder.entity;

@FunctionalInterface
public interface DrawRule {
    Direction nextDirection();
}
