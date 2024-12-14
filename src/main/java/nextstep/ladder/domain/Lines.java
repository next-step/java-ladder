package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines() {
        this(new ArrayList<Line>());
    }

    public Lines(ArrayList<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public void generateLine(int participantCnt, int maxLadder, LineStrategy lineStrategy) {
        for (int i = 0; i < maxLadder; i++) {
            generateLine(participantCnt, lineStrategy);
        }
    }

    private void generateLine(int participantCnt, LineStrategy lineStrategy) {
        Line line = new Line(participantCnt, lineStrategy);
        lines.add(line);
    }

    public int size() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getLineSize(int linesIdx) {
        return lines.get(linesIdx).size();
    }

    public boolean getPoint(int linesIdx, int lineIdx) {
        return lines.get(linesIdx).getLine(lineIdx);
    }
}
