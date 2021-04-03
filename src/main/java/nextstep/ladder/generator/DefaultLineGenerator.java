package nextstep.ladder.generator;

import nextstep.ladder.domain.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class DefaultLineGenerator implements LineGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public List<Point> createLine(final int countOfPerson) {

        List<Point> points = new ArrayList<>(Arrays.asList(Point.initFalse()));
        // 초기 값 설정으로 1부터 시작
        IntStream.range(points.size(), countOfPerson)
                .forEach(value -> addNextPoint(points, value));

        return points;
    }

    private void addNextPoint(List<Point> points, int value) {
        Point point = points.get(value - 1);
        points.add(point(point.isExist()));
    }

    private Point point(boolean point) {
        if(point) {
            return Point.initFalse();
        }
        return Point.of(RANDOM.nextBoolean());
    }
}
