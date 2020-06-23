package nextstep.ladder.domain;

import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ladder {
    private final Map<Order, LadderLine> ladderLines = new HashMap<>();

    public Ladder(final int numberOfUsers, final LadderConnectionConditional conditional, final int maxHeight) {
        for (int orderValue = 1; orderValue < numberOfUsers; orderValue++) {
            addLine(Order.of(orderValue), conditional, Point.of(maxHeight));
        }
        addLastEmptyLine(numberOfUsers, Point.of(maxHeight));
    }

    private void addLine(Order order, LadderConnectionConditional conditional, final Point maxPoint) {
        Set<Point> points = makePoints(order, conditional, maxPoint);
        ladderLines.put(order, LadderLine.of(points));
    }

    private void addLastEmptyLine(final int numberOfUsers, final Point maxPoint) {
        addLine(Order.of(numberOfUsers), () -> false, maxPoint);
    }

    private Set<Point> makePoints(final Order order, final LadderConnectionConditional connectionConditional, final Point maxPoint) {
        Set<Point> points = new HashSet<>();
        Point currentPoint = Point.INITIAL_POINT;

        while (currentPoint.isUnderThanAndEquals(maxPoint) && isEnableToStore(maxPoint, points)) {
            if (connectionConditional.isEnough() && canConnect(order, currentPoint)) {
                points.add(currentPoint);
            }
            currentPoint = currentPoint.next();
        }

        return points;
    }

    private boolean isEnableToStore(final Point maxPoint, final Set<Point> points) {
        return points.size() < maxPoint.getPosition() - 1;
    }

    private boolean canConnect(Order order, Point point) {
        return order.before()
                .map(beforeOrder -> !ladderLines.get(beforeOrder).connectedWith(point))
                .orElse(true);
    }

    public boolean hasConnection(final Order order, final Point point) {
        return ladderLines.get(order).connectedWith(point);
    }

    public boolean hasConnection(final int order, final int point) {
        return hasConnection(Order.of(order), Point.of(point));
    }
}
