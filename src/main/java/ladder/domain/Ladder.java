package ladder.domain;

import java.util.ArrayList;
import java.util.List;


public class Ladder {

    private List<LadderLine> ladderLines;

    private Ladder(LadderSize ladderSize) {
        generateLadder(ladderSize);
    }

    public static Ladder from(LadderSize ladderSize) {
        return new Ladder(ladderSize);
    }

    private List<LadderLine> generateLadder(LadderSize ladderSize) {
        ladderLines = new ArrayList();
        for (int i = 0; i < ladderSize.heightSize(); i++) {
            ladderLines.add(LadderLine.create(ladderSize.wightSize()));
        }
        return ladderLines;
    }

    public int progressGame(int index) {
        int position = 0;
        for (LadderLine line : ladderLines) {
            position = line.move(index);
        }
        return position;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LadderLine line : ladderLines) {
            stringBuilder.append(line.toString()+"\n");
        }
        return stringBuilder.toString();
    }

}
