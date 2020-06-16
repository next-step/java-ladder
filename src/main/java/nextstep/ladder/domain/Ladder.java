package nextstep.ladder.domain;

import java.util.*;

public class Ladder {
    private final int maxHeight;
    private final Map<Order, LadderBaseLine> ladderBaseLines = new HashMap<>();

    public Ladder(final int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void drawLine(LadderGameUser ladderGameUser, LadderLineDrawingMachine drawingMachine) {
        ConnectPoints connectPoints = makeConnectPoints(drawingMachine, ladderGameUser.getOrder());
        ladderBaseLines.put(ladderGameUser.getOrder(), new LadderBaseLine(ladderGameUser, connectPoints));
    }

    private ConnectPoints makeConnectPoints(LadderLineDrawingMachine drawingMachine, Order order) {
        Set<Point> points = new HashSet<>();
        Point currentPoint = Point.INITIAL_POINT;
        Point maxPoint = Point.of(maxHeight);

        while (currentPoint.isUnderThan(maxPoint) || currentPoint.equals(maxPoint)) {
            if (enoughToDrawLine(points.size()) && canConnect(order, currentPoint) && drawingMachine.isEnough()) {
                points.add(currentPoint);
            }
            currentPoint = currentPoint.add();
        }

        return ConnectPoints.of(Collections.unmodifiableSet(points));
    }

    private boolean canConnect(Order order, Point point) {
        return order.before()
                .map(before -> !ladderBaseLines.get(before).connectedWith(point))
                .orElse(true);
    }

    private boolean enoughToDrawLine(final int size) {
        return size < this.maxHeight - 1;
    }

    public LadderBaseLine findLadderLineByOrder(int order) {
        return ladderBaseLines.get(Order.of(order));
    }

    public LadderBaseLine findLadderLineByOrder(Order order) {
        return ladderBaseLines.get(order);
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getNumberOfUser() {
        return ladderBaseLines.size();
    }
}
