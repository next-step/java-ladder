package ladder.domain;

import ladder.drawable.RandomDraw;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ladder {
    private final VerticalLines verticalLines;
    private final int height;

    public Ladder(Players players, int height) {
        this.verticalLines = new VerticalLines(players.getCount());
        this.height = height;
        verticalLines.drawSideLines(height, new RandomDraw());
    }

    public VerticalLines getVerticalLines() {
        return verticalLines;
    }

    public int getHeight() {
        return height;
    }

    public MatchedLineInfos getMatchedInfos() {
        Map<Integer, Integer> matchedInfos = new LinkedHashMap<>();
        for (int i = 1; i <= verticalLines.getSize(); i++) {
            matchedInfos.put(verticalLines.getLine(i).getLineNo(), getResultLine(verticalLines.getLine(i)).getLineNo());
        }
        return new MatchedLineInfos(matchedInfos);
    }

    public VerticalLine getResultLine(VerticalLine verticalLine) {
        for (int i = 1; i <= this.height; i++) {
            verticalLine = nextLine(verticalLine, i);
        }
        return verticalLine;
    }

    private VerticalLine nextLine(VerticalLine verticalLine, int height) {
        if (verticalLine.isExistPoint(height)) {
            return this.verticalLines.getLine(verticalLine.getPoint(height).getEndPointLineNo());
        }
        return verticalLine;
    }
}
