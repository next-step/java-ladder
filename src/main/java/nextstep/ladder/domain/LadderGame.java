package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LadderGame {
    private final LadderLineDrawingMachine drawingMachine;

    public LadderGame(LadderLineDrawingMachine drawingMachine) {
        this.drawingMachine = drawingMachine;
    }

    public Ladder createLadder(final LadderGameUsers ladderGameUsers, final int maxHeight) {
        List<LadderGameUser> gameUsers = ladderGameUsers.getLadderGameUsers();
        Ladder ladder = new Ladder(maxHeight);

        for (int currentUser = 0, size = gameUsers.size(); currentUser < size - 1; currentUser++) {
            ConnectPoints connectPoints = makeConnectPoints(ladder, currentUser);

            ladder.addConnection(new LadderVerticalBaseLine(gameUsers.get(currentUser), connectPoints));
        }

        ladder.addConnection(new LadderVerticalBaseLine(gameUsers.get(gameUsers.size() - 1), ConnectPoints.emptyPoints()));

        return ladder;
    }

    private ConnectPoints makeConnectPoints(Ladder ladder, int currentUserIndex) {
        Set<Point> points = new HashSet<>();
        Point point = Point.INITIAL_POINT;
        int maxHeight = ladder.getMaxHeight();
        while (enoughToDrawLine(points, maxHeight)) {
            if (canDraw(ladder, currentUserIndex, point)) {
                points.add(point);
            }
            point = point.plus();
        }
        return ConnectPoints.of(Collections.unmodifiableSet(points), maxHeight);
    }

    private boolean enoughToDrawLine(Set<Point> points, int maxHeight) {
        return points.size() < maxHeight - 1;
    }

    private boolean canDraw(Ladder ladder, int currentUserIndex, Point point) {
        if (isFirstUserLine(currentUserIndex) || ladder.canConnect(currentUserIndex, point)) {
            return drawingMachine.attemptToDraw();
        }
        return false;
    }

    private boolean isFirstUserLine(int currentUserIndex) {
        return currentUserIndex == 0;
    }
}
