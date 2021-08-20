package ladder.domain;

import ladder.exception.InvalidInputException;
import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final String INVALID_HEIGHT_MESSAGE = "2이상의 높이를 입력해주세요";

    private List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int height) {
        if (height < 2) {
            throw new InvalidInputException(INVALID_HEIGHT_MESSAGE);
        }

        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, height)
                 .forEach(point -> points.add(false));

        return new Line(points);
    }


    public static Line of(int height, Line line) {
        List<Boolean> points = new ArrayList<>();
        while (!valid(points)) {
            points.clear();
            IntStream.range(0, height)
                     .forEach(point -> points.add(PointStrategy.generate(line.getPoints().get(point))));
        }

        return new Line(points);
    }

    private static boolean valid(List<Boolean> line) {
        if (line.stream().noneMatch(point -> point == true)) {
            return false;
        }
        return true;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }


}