package ladder.domain.core.line.move;

import java.util.List;

import ladder.domain.core.rule.PointLinkingRule;

import static java.util.stream.Collectors.toList;

class MovablePoints {
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

    Point getPoint(int index){
        if (0 > index || points.size() < index){
            return Point.empty();
        }
        return points.get(index);
    }

    int move(int prevIndex){
        Point linkingPoint = getPoint(prevIndex).linkingPoint();
        if (linkingPoint.isNotEmpty()) {
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
