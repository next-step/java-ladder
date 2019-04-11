package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;
    private static final String LINE_SEPARATOR = "line.separator";

    public Ladder(int countOfPerson, int height) {
        this.ladder = generateLadder(countOfPerson, height);
    }

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    private List<Line> generateLadder(int countOfPerson, int height) {
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
        return lines;
    }

    public int ladderHeight() {
        return ladder.size();
    }

    public int lineCount() {
        return ladder.get(0).lineCount();
    }

    private Line getLine(int index) {
        return ladder.get(index);
    }

    public Iterator<Line> iterator() {
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
