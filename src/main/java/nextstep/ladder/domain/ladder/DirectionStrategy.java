package nextstep.ladder.domain.ladder;

@FunctionalInterface
public interface DirectionStrategy {
    boolean generate();
}
