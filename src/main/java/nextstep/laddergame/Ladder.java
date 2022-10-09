package nextstep.laddergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<List<LadderPiece>> board;

    Ladder(int width, int height) {
        List<List<LadderPiece>> ladder = new ArrayList<>();
        for (int innerIndex = 0; innerIndex < height; innerIndex++) {
            List<LadderPiece> line = new ArrayList<>();
            for (int outerIndex = 0; outerIndex < width; outerIndex++) {
                line.add(new LadderPiece());
            }
            ladder.add(Collections.unmodifiableList(line));
        }
        this.board = Collections.unmodifiableList(ladder);
    }

    public List<List<LadderPiece>> getBoard() {
        return board;
    }
}
