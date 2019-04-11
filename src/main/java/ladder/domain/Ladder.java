package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder {
    private final List<LadderLine> ladder;
    private static final String LINE_SEPARATOR = "line.separator";

    public Ladder(int countOfPerson, int height) {
        this.ladder = generateLadder(countOfPerson, height);
    }

    public Ladder(List<LadderLine> ladder) {
        this.ladder = ladder;
    }

    private List<LadderLine> generateLadder(int countOfPerson, int height) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.init(countOfPerson));
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
