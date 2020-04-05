package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public static Ladder of(Users users, Height height) {
        List<LadderLine> newLadderLines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            newLadderLines.add(LadderLine.of(users.getUserCount()));
        }
        return new Ladder(newLadderLines);
    }

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
