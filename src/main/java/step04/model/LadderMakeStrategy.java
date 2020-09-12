package step04.model;

@FunctionalInterface
public interface LadderMakeStrategy {

    Point makePoint(Point previousPoint);
}
