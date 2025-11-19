package nextstep.ladder.domain;

import engine.LinesCreator;
import nextstep.ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;

public class NextStepLines implements LinesCreator {
    private final List<Line> lines;

    public NextStepLines(int participantCnt, int maxLadder, LineStrategy lineStrategy) {
        this.lines = new ArrayList<>();
        generateLine(participantCnt, maxLadder, lineStrategy);
    }

    public NextStepLines(ArrayList<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    private void generateLine(int participantCnt, int maxLadder, LineStrategy lineStrategy) {
        for (int i = 0; i < maxLadder; i++) {
            generateLine(participantCnt, lineStrategy);
        }
    }

    private void generateLine(int participantCnt, LineStrategy lineStrategy) {
        Line line = new Line(participantCnt, lineStrategy);
        lines.add(line);
    }

    @Override
    public List<Line> getLines() {
        return lines;
    }

    public int getLineSize(int linesIdx) {
        return lines.get(linesIdx).size();
    }

    public boolean getPoint(int linesIdx, int lineIdx) {
        return lines.get(linesIdx).getLine(lineIdx);
    }

    public int size() {
        return lines.size();
    }
}
