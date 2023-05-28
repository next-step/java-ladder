package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static final int START_Y = 0;
    private List<LadderRow> rows;

    public Ladder(int height, int countOfPlayers) {
        rows = generateRows(height, countOfPlayers);
    }

    public List<LadderRow> getRows() {
        return rows;
    }

    private List<LadderRow> generateRows(int height, int countOfPlayers) {
        final List<LadderRow> newRows = new ArrayList();

        for (int i = 0; i < height; i++) {
            newRows.add(new LadderRow(countOfPlayers - 1));
        }

        return newRows;
    }

    public Result play(Players players, Prizes prizes) {
        Result result = new Result();
        for (int i = 0; i < players.size(); i++) {
            Point endPoint = moveToEnd(i);
            result.put(players.get(i), prizes.get(endPoint.getX()));
        }
        return result;
    }

    private Point moveToEnd(int startX) {
        Point point = new Point(startX, START_Y);
        while (!point.isOnY(rows.size())) {
            point = point.move(rows.get(point.getY()).determineDirection(point.getX()));
        }
        return point;
    }

    public int size() {
        return rows.size();
    }
}