package nextstep.ladder.domain.strategy;

@FunctionalInterface
public interface LineCreateStrategy {
    boolean isCreatable();
}
