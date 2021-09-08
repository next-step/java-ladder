package nextstep.ladder.domain;

import java.util.List;

public class Position {

    public static final int OFFSET = 1;

    private int startPosition;

    private int lastPosition;

    public Position(int startPosition, int lastPosition) {
        this.startPosition = startPosition;
        this.lastPosition = lastPosition;
    }

    public Position(int startPosition) {
        this.startPosition = startPosition;
    }

    public Result findUserResult(List<Result> results) {
        return results.get(lastPosition);
    }

    public int findLastPosition(Ladder ladder) {
        lastPosition = ladder.move(startPosition);
        return lastPosition;
    }
}
