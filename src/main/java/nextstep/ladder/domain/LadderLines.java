package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LadderLines {
    private final Map<Order, LadderLine> ladderLines = new HashMap<>();

    public void addLine(Order order, LadderGameUser gameUser, LadderConnectionLineConditional connectionLineConditional, final int maxHeight) {
        ConnectPoints connectPoints = makeConnectPoints(order, connectionLineConditional, maxHeight);
        ladderLines.put(order, LadderLine.of(gameUser, connectPoints));
    }

    private ConnectPoints makeConnectPoints(final Order order, final LadderConnectionLineConditional drawingMachine, final int maxHeight) {
        Set<Point> points = new HashSet<>();
        Point currentPoint = Point.INITIAL_POINT;
        Point maxPoint = Point.of(maxHeight);

        while (currentPoint.isUnderThan(maxPoint) || currentPoint.equals(maxPoint)) {
            if (points.size() < maxHeight - 1 && canConnect(order, currentPoint) && drawingMachine.isEnough()) {
                points.add(currentPoint);
            }
            currentPoint = currentPoint.add();
        }
        return ConnectPoints.of(points);
    }

    private boolean canConnect(Order order, Point point) {
        return order.before()
                .map(beforeOrder -> !ladderLines.get(beforeOrder).connectedWith(point))
                .orElse(true);
    }

    public int count() {
        return ladderLines.size();
    }

    public LadderLine findLadderLineByOrder(final int order) {
        return ladderLines.get(Order.of(order));
    }

}
