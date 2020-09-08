package step04.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {

    private final List<DirectionPoint> directionPoints;

    private LadderLine(List<DirectionPoint> directionPoints) {
        this.directionPoints = Collections.unmodifiableList(directionPoints);
    }

    public static LadderLine of(int columnNum, LadderMakeStrategy ladderMakeStrategy) {
        List<DirectionPoint> directionPoints = new LinkedList<>();

        Point previousPoint =  ladderMakeStrategy.makePoint(null);
        directionPoints.add(DirectionPoint.of(Point.BLANK, previousPoint));

        for(int index = 0 ; index < columnNum -2 ; index ++) {
            Point point = ladderMakeStrategy.makePoint(previousPoint);
            directionPoints.add(DirectionPoint.of(previousPoint, point));
            previousPoint = point;
        }

        directionPoints.add(DirectionPoint.of(previousPoint, Point.BLANK));

        return new LadderLine(directionPoints);
    }

    public String getPrintableLadderLine() {
        return directionPoints.stream()
                .map(DirectionPoint::toString)
                .collect(Collectors.joining());
    }

    public RouteInfo<Integer> getRouteInfo() {
        return new RouteInfo<>(new HashMap<>());
    }
}
