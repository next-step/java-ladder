package nextstep.ladder.domain;

import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static nextstep.ladder.domain.vo.Point.INITIAL_POINT;

public class Ladder {
    private final Map<Order, LadderLine> ladderLines = new HashMap<>();

    private Ladder(final int numberOfUsers, final LadderConnectionConditional conditional, final int maxPoint) {
        init(numberOfUsers, conditional, maxPoint);
    }

    public static Ladder of(final int numberOfUsers, final LadderConnectionConditional conditional, final int maxPoint) {
        return new Ladder(numberOfUsers, conditional, maxPoint);
    }

    private void init(final int numberOfUsers, final LadderConnectionConditional conditional, final int maxPoint) {
        for (int orderValue = 1; orderValue < numberOfUsers; orderValue++) {
            Order order = Order.of(orderValue);
            Set<Point> points = makePoints(order, conditional, Point.of(maxPoint));
            ladderLines.put(order, LadderLine.of(points));
        }
        addLastEmptyLine(numberOfUsers, Point.of(maxPoint));
    }

    private void addLastEmptyLine(final int numberOfUsers, final Point maxPoint) {
        Order order = Order.of(numberOfUsers);
        Set<Point> points = makePoints(order, () -> false, maxPoint);
        ladderLines.put(order, LadderLine.of(points));
    }

    private Set<Point> makePoints(final Order order, final LadderConnectionConditional connectionConditional, final Point maxPoint) {
        Set<Point> points = new HashSet<>();
        Point currentPoint = INITIAL_POINT;

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
