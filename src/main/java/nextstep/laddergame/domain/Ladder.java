package nextstep.laddergame.domain;

import nextstep.laddergame.wrapper.Height;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int width, Height height, BridgeInterface bridgeInterface) {
        this.lines = Collections.unmodifiableList(getLadderTemplate(width, height.getLadderHeight()));
        settingBridgeOnAllLine(bridgeInterface);
    }

    public List<Line> getLines() {
        return lines;
    }

    public Line getStartLine() {
        return this.getLines().get(0);
    }

    private List<Line> getLadderTemplate(int width, int height) {
        List<Line> ladderTemplate = new ArrayList<>();
        Line topLine = null;
        for (int innerIndex = 0; innerIndex < height; innerIndex++) {
            Line line = new Line(width);
            connectLine(topLine, line);
            topLine = line;
            ladderTemplate.add(line);
        }
        return ladderTemplate;
    }

    private void connectLine(Line topLine, Line bottomLine) {
        if (topLine == null) {
            return;
        }
        topLine.connectToUnder(bottomLine);
    }

    private void settingBridgeOnAllLine(BridgeInterface bridgeInterface) {
        this.lines.forEach((line) -> line.settingBridgeOnAllPiece(bridgeInterface));
    }

}
