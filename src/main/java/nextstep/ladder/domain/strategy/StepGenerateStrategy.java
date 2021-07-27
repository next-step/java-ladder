package nextstep.ladder.domain.strategy;

@FunctionalInterface
public interface StepGenerateStrategy {
    boolean isGenerable();
}
