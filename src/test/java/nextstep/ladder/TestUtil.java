package nextstep.ladder;

import nextstep.ladder.domain.Point;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtil {

    public static List<Point> asPointList(Boolean... points) {
        return Arrays.stream(points)
                .map(Point::of)
                .collect(Collectors.toList());
    }
}
