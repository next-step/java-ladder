package ladder.domain.core.line.move;

import java.util.List;

import ladder.domain.core.rule.PointLinkingRule;

import static java.util.stream.Collectors.toList;

class MovablePoints {
    static final String ERROR_MSG_OUT_OF_RANGE_INDEX = "잘못된 index 입니다.";
    private final List<Point> points;

    MovablePoints(List<Point> points) {
        this.points = points;
    }

    static MovablePoints of(int maxPointCount){
        List<Point> points = LinkingRuleBaseGeneratePoints.generatePoints(PointLinkingRule.defaultRule(), maxPointCount);
        return new MovablePoints(points);
    }

    static MovablePoints of(PointLinkingRule rule, int maxPointCount){
        List<Point> points = LinkingRuleBaseGeneratePoints.generatePoints(rule, maxPointCount);
        return new MovablePoints(points);
    }

    static MovablePoints ofCustomLink(int maxPointCount, int...select){
        List<Point> points = LinkingSelectBaseGeneratePoints.generatePoints(maxPointCount, select);
        return new MovablePoints(points);
    }

    Point getPointByIndex(int index){
        verifyIndex(index);
        return points.get(index);
    }

    private void verifyIndex(int index) {
        if (0 > index || points.size() < index){
            throw new IllegalArgumentException(ERROR_MSG_OUT_OF_RANGE_INDEX);
        }
    }

    int move(int prevIndex){
        Point currentPoint = getPointByIndex(prevIndex);
        Point linkingPoint = currentPoint.linkingPoint();

        System.out.println(currentPoint + ", " + linkingPoint);
        if (currentPoint.isNotEmpty() && linkingPoint.isNotEmpty()) {
            return linkingPoint.getIndex();
        }
        return prevIndex;
    }

    List<Boolean> collectLinkState(){
        return points.stream()
                     .map(Point::hasLink)
                     .collect(toList());
    }
}
