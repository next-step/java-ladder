package ladder.domain.common;

@FunctionalInterface
public interface MoveStrategy {
    Point move(Point point);
}
