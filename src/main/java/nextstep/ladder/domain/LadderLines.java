package nextstep.ladder.domain;

import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LadderLines {
    private final Map<Order, LadderLine> ladderLines = new HashMap<>();

    public void addLine(Order order, LadderConnectionConditional connectionConditional, final Point maxPoint) {
        ConnectPoints connectPoints = makeConnectPoints(order, connectionConditional, maxPoint);
        ladderLines.put(order, LadderLine.of(connectPoints));
    }

    private ConnectPoints makeConnectPoints(final Order order, final LadderConnectionConditional connectionConditional, final Point maxPoint) {
        Set<Point> points = new HashSet<>();
        Point currentPoint = Point.INITIAL_POINT;

        while (currentPoint.isUnderThanAndEquals(maxPoint) && isEnableToStore(maxPoint, points)) {
            if (connectionConditional.isEnough() && canConnect(order, currentPoint)) {
                points.add(currentPoint);
            }
            currentPoint = currentPoint.next();
        }

        return ConnectPoints.of(points);
    }

    private boolean isEnableToStore(final Point maxPoint, final Set<Point> points) {
        return points.size() < maxPoint.getPosition() - 1;
    }

    private boolean canConnect(Order order, Point point) {
        return order.before()
                .map(beforeOrder -> !ladderLines.get(beforeOrder).connectedWith(point))
                .orElse(true);
    }

    public int count() {
        return ladderLines.size();
    }

    public boolean hasConnection(final Order order, final Point point) {
        return ladderLines.get(order).connectedWith(point);
    }

    public boolean hasConnection(final int order, final int point) {
        return ladderLines.get(Order.of(order)).connectedWith(point);
    }
}
