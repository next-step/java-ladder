package nextstep.ladder.domain.line.strategy;

@FunctionalInterface
public interface LineCreateStrategy {
    boolean create(boolean prevPoint);
}
