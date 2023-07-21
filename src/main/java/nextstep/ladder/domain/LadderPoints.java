package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LadderPoints {

    private final int ladderLength;
    private final int playerCount;
    private final List<LadderPoint> ladderPoints;

    private LadderPoints(int ladderLength, int playerCount, List<LadderPoint> ladderPoints) {
        this.ladderLength = ladderLength;
        this.playerCount = playerCount;
        this.ladderPoints = ladderPoints;
    }

    public static LadderPoints of(int ladderLength, int playerCount, LadderBarStatusDecider ladderBarStatusDecider) {
        List<LadderPoint> ladderPoints = new ArrayList<>();
        for (int row = 0; row <= ladderLength; row++) {
            LadderBarStatus cache = LadderBarStatus.EMPTY;
            for (int column = 0; column <= playerCount - 1; column++) {
                cache = ladderBarStatusDecider.decide(cache);
                ladderPoints.add(new LadderPoint(row, column, cache));
            }
        }

        return new LadderPoints(ladderLength, playerCount, ladderPoints);
    }

    public LadderPoint head() {
        return this.ladderPoints.get(0);
    }

    public LadderPoint get(int row, int column) {
        return this.ladderPoints.get(getLadderPointIndex(row, column));
    }

    public LadderPoint next(LadderPoint ladderPoint) {
        return this.next(ladderPoint.getRow(), ladderPoint.getColumn());
    }

    public LadderPoint next(int row, int column) {
        if (row >= this.ladderLength && column >= this.playerCount - 1) {
            throw new IllegalArgumentException(String.format("다음 값이 사다리 범위내에 존재하지 않습니다. 입력한 값 : row=%d, column=%d", row, column));
        }

        if (column + 1 <= this.playerCount) {
            return this.get(row, column + 1);
        }

        return this.get(row + 1, 0);
    }

    private int getLadderPointIndex(int row, int column) {
        return row * this.playerCount + column;
    }
}
