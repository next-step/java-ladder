package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class TestUtil {

    public static List<Point> asPointList(Boolean... points) {
        return Arrays.stream(points)
                .map(Point::of)
                .collect(Collectors.toList());
    }

    public static Line asLine(Boolean... points) {
        return Arrays.stream(points)
                .map(Point::of)
                .collect(collectingAndThen(toList(), Line::new));
    }
}
