package nextstep.ladder.doman;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final static StringBuilder stringBuilder = new StringBuilder();

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson, PointConnectStrategy pointConnectStrategy) {
        validate(countOfPerson, pointConnectStrategy);
        addPoints(countOfPerson, pointConnectStrategy);
    }

    private void validate(int countOfPerson, PointConnectStrategy pointConnectStrategy) {
        if (countOfPerson <= 0) {
            throw new IllegalArgumentException(String.format("참가자가 없으면 진행할 수 없습니다. 참가자 수 : %d", countOfPerson));
        }

        if (pointConnectStrategy == null) {
            throw new IllegalArgumentException("연결 전략이 없을 수 없습니다.");
        }
    }

    private void addPoints(int countOfPerson, PointConnectStrategy pointConnectStrategy) {
        addFirstPoint(pointConnectStrategy);
        for (int i = 0; i < countOfPerson - 2; i++) {
            PointDirection pointDirection = new PointDirection(points.get(i));
            points.add(new Point(pointDirection, pointConnectStrategy.isConnected()));
        }
        addLastPoint();
    }

    private void addFirstPoint(PointConnectStrategy pointConnectStrategy) {
        points.add(new Point(pointConnectStrategy.isConnected()));
    }

    private void addLastPoint() {
        points.add(new Point(false));
    }

    @Override
    public String toString() {
        stringBuilder.setLength(0);
        stringBuilder.append("   ");
        stringBuilder.append(points.stream().map(Point::toString).collect(Collectors.joining()));
        return stringBuilder.toString();
    }
}
