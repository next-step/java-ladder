package ladder.domain.core.line.move;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import ladder.domain.core.rule.PointLinkingRule;

import static java.util.stream.Collectors.toList;

class LinkingRuleBaseGeneratePoints {
    static List<Point> generatePoints(PointLinkingRule rule, int maxPointCount) {
        List<Point> pointList = IntStream.range(0, maxPointCount)
                                         .mapToObj(Point::new)
                                         .collect(toList());
        for (int i = 1; i < pointList.size(); ++i) {
            linkingPoint(rule, pointList, i);
        }

        return Collections.unmodifiableList(pointList);
    }

    private static void linkingPoint(PointLinkingRule rule, List<Point> pointList, int index) {
        if (rule.shouldLinking()) {
            Point p1 = pointList.get(index - 1);
            Point p2 = pointList.get(index);
            p1.link(p2);
        }
    }
}
