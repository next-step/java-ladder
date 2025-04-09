package nextstep.ladder.domain.line;

public interface LineCreateStrategy {
    boolean createFirstPoint();
    boolean createNextPoint(boolean prevPoint);
}
