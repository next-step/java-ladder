package nextstep.ladder.domain;

import java.util.*;

public class Ladder {
    private final int maxHeight;
    private final Map<Order, LadderBaseLine> ladderBaseLines = new HashMap<>();

    public Ladder(final int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void drawLine(LadderGameUser ladderGameUser, LadderLineDrawingMachine drawingMachine) {
        Optional<Order> beforeOrder = ladderGameUser.getOrder().before();
        if (!beforeOrder.isPresent()) {
            ConnectPoints connectPoints = makeConnectPoints(drawingMachine);
            ladderBaseLines.put(ladderGameUser.getOrder(), new LadderBaseLine(ladderGameUser, connectPoints));
            return;
        }
        ConnectPoints connectPoints = makeConnectPoints(drawingMachine, beforeOrder.get());
        ladderBaseLines.put(ladderGameUser.getOrder(), new LadderBaseLine(ladderGameUser, connectPoints));
    }

    private ConnectPoints makeConnectPoints(LadderLineDrawingMachine drawingMachine) {
        Set<Point> points = new HashSet<>();
        Point point = Point.INITIAL_POINT;
        while (enoughToDrawLine(points)) {
            if (drawingMachine.isEnough()) {
                points.add(point);
            }
            point = point.add();
        }
        return ConnectPoints.of(Collections.unmodifiableSet(points), maxHeight);
    }

    private ConnectPoints makeConnectPoints(LadderLineDrawingMachine drawingMachine, Order beforeOrder) {
        LadderBaseLine beforeLadderBaseLine = ladderBaseLines.get(beforeOrder);
        Set<Point> points = new HashSet<>();
        Point point = Point.INITIAL_POINT;
        while (enoughToDrawLine(points)) {
            if (!beforeLadderBaseLine.connectedWith(point) && drawingMachine.isEnough()) {
                points.add(point);
            }
            point = point.add();
        }
        return ConnectPoints.of(Collections.unmodifiableSet(points), maxHeight);
    }

    private boolean enoughToDrawLine(Set<Point> points) {
        return points.size() < this.maxHeight - 1;
    }

    public LadderBaseLine findByOrder(Order order) {
        return ladderBaseLines.get(order);
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getNumberOfUser() {
        return ladderBaseLines.size();
    }
}
