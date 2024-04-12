package strategy;

import domain.Point;

import java.util.List;

public interface PointsMakeStrategy {
    List<Point> makePoints(int playerCount);
}
