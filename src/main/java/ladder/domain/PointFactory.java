package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static ladder.domain.Point.LEFT;
import static ladder.domain.Point.RIGHT;
import static ladder.domain.Point.STOP;

public class PointFactory {
    public static List<Point> createPointsFromLinks(List<Boolean> links) {
        return IntStream.rangeClosed(0, links.size())
            .mapToObj(idx -> {
                if (isLeft(links, idx)) {
                    return LEFT;
                }

                if (isRight(links, idx)) {
                    return RIGHT;
                }

                return STOP;
            })
            .collect(toList());
    }

    private static boolean isRight(List<Boolean> links, int idx) {
        return idx < links.size() && links.get(idx);
    }

    private static boolean isLeft(List<Boolean> links, int idx) {
        return idx > 0 && links.get(idx - 1);
    }
}
