package step2.model;

import step2.ganerator.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points = new ArrayList<>();
    private Point point;

    private Line(Person person, RandomGenerator randomGenerator) {
        point = Point.first(randomGenerator.randomLadder());
        points.add(point);

        IntStream.range(1, person.nameSize()).forEach(i -> {
            Point next = point.next(!point.isRight() && randomGenerator.randomLadder());  // 왼쪽이 true면 오른쪽은 false로 설정
            points.add(next);
            point = next;
        });
    }

    // 라인을 생성한다.
    public static Line createLine(Person person, RandomGenerator randomGenerator) {
        return new Line(person, randomGenerator);
    }

    // 좌우로 살피고 true인 라인으로 옮긴다.
    public int getLineForward(int position) {
        return points.get(position).move(position);
    }

    public int pointSize() {
        return points.size();
    }

    public List<Point> getPoints() {
        return points;
    }
}
