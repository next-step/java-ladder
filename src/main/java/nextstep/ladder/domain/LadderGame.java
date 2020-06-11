package nextstep.ladder.domain;

import java.util.*;

public class LadderGame {
    private final LadderLineDrawingMachine drawingMachine;

    public LadderGame(LadderLineDrawingMachine drawingMachine) {
        this.drawingMachine = drawingMachine;
    }

    public Ladder createLadder(final LadderGameUsers ladderGameUsers, final int maxHeight) {
        List<LadderGameUser> gameUsers = ladderGameUsers.getLadderGameUsers();
        List<BaseUserLine> baseUserLines = new ArrayList<>();

        for (int currentUser = 0, size = gameUsers.size(); currentUser < size - 1; currentUser++) {
            Set<Point> points = makeConnectionPoints(maxHeight, baseUserLines, currentUser);

            baseUserLines.add(new BaseUserLine(gameUsers.get(currentUser), new ConnectPoints(points, maxHeight)));
        }

        baseUserLines.add(new BaseUserLine(gameUsers.get(gameUsers.size() - 1), new ConnectPoints(new HashSet<>(), maxHeight)));

        return new Ladder(maxHeight, baseUserLines);
    }

    private Set<Point> makeConnectionPoints(int maxHeight, List<BaseUserLine> baseUserLines, int currentUserIndex) {
        Set<Point> points = new HashSet<>();
        for (int position = 0; position < maxHeight && points.size() < maxHeight - 1; position++) {
            if (canDraw(baseUserLines, currentUserIndex, position)) {
                points.add(Point.of(position));
            }
        }
        return Collections.unmodifiableSet(points);
    }

    private boolean canDraw(List<BaseUserLine> baseUserLines, final int currentUserIndex, final int position) {
        if (currentUserIndex == 0 || !baseUserLines.get(currentUserIndex - 1).isConnected(Point.of(position))) {
            return drawingMachine.canDraw();
        }
        return false;
    }
}
