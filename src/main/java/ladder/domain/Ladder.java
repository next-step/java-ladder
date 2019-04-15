package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder {
    private static final String LINE_SEPARATOR = "line.separator";
    private final List<LadderLine> ladder;

    public Ladder(int countOfPerson, Level level) {
        BooleanGenerator booleanGenerator = new BooleanGeneratorWithLevel(level);
        this.ladder = generateLadder(countOfPerson, level.getHeight(), booleanGenerator);
    }

    public Ladder(int countOfPerson, int height) {
        BooleanGenerator booleanGenerator = new BooleanGeneratorNormal();
        this.ladder = generateLadder(countOfPerson, height, booleanGenerator);
    }

    private List<LadderLine> generateLadder(int countOfPerson, int height, BooleanGenerator booleanGenerator) {
        List<LadderLine> ladderLines = new ArrayList<>();

        for(int i = 0; i < height; i++) {
            ladderLines.add(new LadderLine(countOfPerson, booleanGenerator));
        }
        return ladderLines;
    }

    public int ladderHeight() {
        return ladder.size();
    }

    public int lineCount() {
        return ladder.get(0).lineCount();
    }

    private LadderLine getLine(int index) {
        return ladder.get(index);
    }

    public Iterator<LadderLine> iterator() {
        return ladder.iterator();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int ladderHeight = ladderHeight();
        for(int i = 0; i < ladderHeight; i++) {
            stringBuffer.append(getLine(i).toString());
            stringBuffer.append(System.getProperty(LINE_SEPARATOR));
        }
        return stringBuffer.toString();
    }
}
