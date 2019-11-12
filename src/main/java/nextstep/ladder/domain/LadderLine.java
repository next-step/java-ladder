package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 19:40
 */
public class LadderLine {

    private final List<Point> points = new ArrayList<>();
    private final int countOfPerson;

    public LadderLine(int countOfPerson) {
        this.countOfPerson = countOfPerson;
        create();
    }

    private void create() {
        Point point = Point.first();
        points.add(point);
        while (countOfPerson != points.size()) {
            point = point.next();
            points.add(point);
        }
    }

    public List<LadderBridge> showLine() {
        return points
                .stream()
                .map(Point::pointToBridge)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine line = (LadderLine) o;
        return countOfPerson == line.countOfPerson &&
                Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, countOfPerson);
    }
}