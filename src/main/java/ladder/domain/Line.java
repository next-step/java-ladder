package ladder.domain;

import ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final Integer INIT_POINT_LIST_SIZE = 0;

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            this.points.add(connect(this.points, RandomUtil::getRandomBoolean));
        }
    }

    private Point connect(List<Point> pointList, Connection connection) {
        return pointList.size() == INIT_POINT_LIST_SIZE ? new Point(connection.connect()) : validatePoint(pointList, connection);
    }

    private Point validatePoint(List<Point> pointList, Connection connection) {
        return pointList.get(pointList.size() - 1).getPoint() ? new Point(Boolean.FALSE) : new Point(connection.connect());
    }

    public List<Boolean> getPoints() {
        return points.stream()
                .map(Point::getPoint).collect(Collectors.toList());
    }
}
