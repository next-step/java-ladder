package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderPoints {

    private final int ladderLength;
    private final int columnCount;
    private final List<LadderPoint> ladderPoints;

    private LadderPoints(int ladderLength, int columnCount, List<LadderPoint> ladderPoints) {
        this.ladderLength = ladderLength;
        this.columnCount = columnCount;
        this.ladderPoints = ladderPoints;
    }

    public static LadderPoints of(int ladderLength, int playerCount, LadderBarStatusDecider ladderBarStatusDecider) {
        List<LadderPoint> ladderPoints = new ArrayList<>();
        for (int row = 0; row < ladderLength; row++) {
            LadderBarStatus cache = LadderBarStatus.EMPTY;
            fillLadderBarStatus(playerCount, ladderBarStatusDecider, ladderPoints, row, cache);
        }

        return new LadderPoints(ladderLength, playerCount - 1, ladderPoints);
    }

    private static void fillLadderBarStatus(int playerCount, LadderBarStatusDecider ladderBarStatusDecider,
        List<LadderPoint> ladderPoints, int row, LadderBarStatus cache) {
        for (int column = 0; column < playerCount - 1; column++) {
            cache = ladderBarStatusDecider.decide(cache);
            ladderPoints.add(new LadderPoint(row, column, cache));
        }
    }

    public LadderPoint head() {
        return this.ladderPoints.get(0);
    }

    public LadderPoint get(int row, int column) {
        int index = getLadderPointIndex(row, column);

        if (column < 0 || column >= this.columnCount || index >= this.ladderPoints.size()) {
            return new LadderPoint(-1, -1, LadderBarStatus.OUT);
        }

        return this.ladderPoints.get(index);
    }

    private int getLadderPointIndex(int row, int column) {
        return row * this.columnCount + column;
    }

    public int getLadderLength() {
        return ladderLength;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public List<LadderPoint> getLadderPoints() {
        return ladderPoints;
    }
}
