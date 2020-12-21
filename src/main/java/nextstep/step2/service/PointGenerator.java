package nextstep.step2.service;

import nextstep.step2.VO.Point;
import nextstep.step2.VO.Position;

public class PointGenerator {

    public static Point getFirstPoint() {
        return new Point(new Position(0),
                DirectionGenerator.getFirstDirection());
    }

    public static Point getNextPoint(Point previousPoint) {
        return new Point(previousPoint.getPosition(),
                DirectionGenerator.getNextDirection(previousPoint.getDirection()));
    }

    public static Point getLastPoint(Point previousPoint, int ladderWidth) {
        return new Point(new Position(ladderWidth - 1),
                DirectionGenerator.getLastDirection(previousPoint.getDirection()));
    }
}
