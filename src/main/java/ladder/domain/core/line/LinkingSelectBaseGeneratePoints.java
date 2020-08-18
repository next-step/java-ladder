package ladder.domain.core.line;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class LinkingSelectBaseGeneratePoints {
    static List<Point> generatePoints(int maxPointCount, int...selects) {
        List<Point> pointList = IntStream.range(0, maxPointCount)
                                         .mapToObj(Point::new)
                                         .collect(toList());
        for (int select : selects) {
            Point p1 = pointList.get(select);
            Point p2 = pointList.get(select + 1);
            p1.link(p2);
        }

        return Collections.unmodifiableList(pointList);
    }

}
