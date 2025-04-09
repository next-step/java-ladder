package nextstep.ladder.domain.line.strategy;

public interface LineCreateStrategy {
    boolean createFirstPoint();
    boolean createNextPoint(boolean prevPoint);
}
