package nextstep.domain;

import java.util.Collections;
import java.util.List;

public class LadderLines {
    private final List<LadderLine> ladderLines;

    public LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(this.ladderLines);
    }

    public void moveLines(LadderResult ladderResult) {
        int resultSize = ladderResult.getResultSize();
        for (int i = 0; i < resultSize; i++) {
            ladderResult.addResultIndex(move(i));
        }
    }

    public int move(int k) {
        int userPoint = k;
        for (LadderLine ladderLine : this.ladderLines) {
            userPoint = ladderLine.moves(userPoint);
        }
        return userPoint;
    }


}
