package ladder.domain.core.line;
import ladder.domain.core.rule.PointLinkingRule;
import java.util.List;

class MovableLine {
    private final List<Point> points;

    MovableLine(List<Point> points) {
        this.points = points;
    }

    static MovableLine create(int maxPointCount){
        List<Point> points = LinkingRuleBaseGeneratePoints.generatePoints(PointLinkingRule.defaultRule(), maxPointCount);
        return new MovableLine(points);
    }

    static MovableLine create(PointLinkingRule rule, int maxPointCount){
        List<Point> points = LinkingRuleBaseGeneratePoints.generatePoints(rule, maxPointCount);
        return new MovableLine(points);
    }

    static MovableLine createCusteomLink(int maxPointCount, int...select){
        List<Point> points = LinkingSelectBaseGeneratePoints.generatePoints(maxPointCount, select);
        return new MovableLine(points);
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

}
