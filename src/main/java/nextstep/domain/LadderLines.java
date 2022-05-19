package nextstep.domain;

import java.util.Collections;
import java.util.List;

public class LadderLines {
    private static final int MOVE_USER_POINT = 6;
    private final List<LadderLine> ladderLines;

    public LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(this.ladderLines);
    }

    public int pointsSize() {
        return this.ladderLines.get(0).getPoints().size();
    }

    public void moveLines(LadderResult ladderResult) {
        int pointsSize = pointsSize();
        for (int i = 0; i <= pointsSize; i += MOVE_USER_POINT) {
            ladderResult.addResultIndex(move(i));
        }
    }

    public int move(int k) {
        int userPoint = k;
        for (LadderLine ladderLine : this.ladderLines) {
            userPoint = ladderLine.moveLadderLine(userPoint);
        }
        return userPoint;
    }


}
