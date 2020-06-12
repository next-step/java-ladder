package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public int findEndPoint(int playerPosition) {
        for (int lineNumber = 0; lineNumber < ladder.height(); lineNumber++) {
            Line line = ladder.get(lineNumber);
            playerPosition = getNextPosition(line, playerPosition);
        }
        return playerPosition;
    }

    private int getNextPosition(Line line, int playerPosition) {
        if (hasLine(line, playerPosition)) {
            return playerPosition + 1;
        }
        if (hasLine(line, playerPosition - 1)) {
            return playerPosition - 1;
        }
        return playerPosition;
    }

    private boolean hasLine(Line line, int position) {
        if (position < 0) {
            return false;
        }
        Point point = line.get(position);
        return point.hasLine();
    }
}
