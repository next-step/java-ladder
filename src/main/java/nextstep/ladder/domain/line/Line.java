package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.exception.UnknownPointException;
import nextstep.ladder.dto.Connections;
import nextstep.ladder.util.StreamUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final int MINIMUM_POINTS_SIZE = 2;

    private final List<Point> points;

    Line(List<Point> points) {
        validatePointsSize(points);
        validatePoints(points);
        this.points = points;
    }

    private void validatePointsSize(List<Point> points) {
        if (points.size() < MINIMUM_POINTS_SIZE) {
            throw new IllegalArgumentException("최소 두 개 이상의 지점을 가지고 있어야 합니다.");
        }
    }

    private void validatePoints(List<Point> points) {
        long invalidPairs = StreamUtils.pairStream(points)
                                       .filter(pair -> isInvalidPair(pair.getFirst(), pair.getSecond()))
                                       .count();

        if (invalidPairs > 0) {
            throw new IllegalArgumentException("단방향으로 이어진 지점이 존재해서는 안됩니다.");
        }
    }

    private boolean isInvalidPair(Point firstPoint, Point secondPoint) {
        return firstPoint.isConnectedTo(secondPoint) ^ secondPoint.isConnectedTo(firstPoint);
    }

    public Connections exportConnections() {
        List<Boolean> connections =
            StreamUtils.pairStream(points)
                       .map(pointPair -> isConnectedEachOther(pointPair.getFirst(), pointPair.getSecond()))
                       .collect(Collectors.toList());

        return new Connections(connections);
    }

    private boolean isConnectedEachOther(Point firstPoint, Point secondPoint) {
        return firstPoint.isConnectedTo(secondPoint) && secondPoint.isConnectedTo(firstPoint);
    }

    public int nextPosition(int position) {
        return traverse(points.get(position));
    }

    private int traverse(Point point) {
        return getPosition(point.getConnectedPoint());
    }

    private int getPosition(Point target) {
        return IntStream.range(0, points.size())
                        .filter(i -> points.get(i) == target)
                        .findFirst()
                        .orElseThrow(UnknownPointException::new);
    }

}
