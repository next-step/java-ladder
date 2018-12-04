package ladder.domain;

import java.util.ArrayList;
import java.util.List;


public class Ladder {

    private List<LadderLine> ladderLines;

    private Ladder(LadderSize ladderSize, Conditional conditional) {
        generateLadder(ladderSize, conditional);
    }

    public static Ladder from(LadderSize ladderSize, Conditional conditional) {
        return new Ladder(ladderSize, conditional);
    }

    private List<LadderLine> generateLadder(LadderSize ladderSize, Conditional conditional) {
        ladderLines = new ArrayList();
        for (int i = 0; i < ladderSize.heightSize(); i++) {
            ladderLines.add(conditional.generateLine(ladderSize.wightSize()));
        }
        return ladderLines;
    }

    public Position progressGame(Position position) {
        for (LadderLine line : ladderLines) {
            Direction direction = position.checkDirection(line);
            position.move(direction);
        }
        return position;
    }

    public int size() {
        return ladderLines.size();
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
