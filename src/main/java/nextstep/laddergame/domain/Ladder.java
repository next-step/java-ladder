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
        Line topLine = new Line(width);
        ladderTemplate.add(topLine);
        for (int innerIndex = 1; innerIndex < height; innerIndex++) {
            Line line = topLine.makeAndLinkNewLineToUnder();
            topLine = line;
            ladderTemplate.add(line);
        }
        return ladderTemplate;
    }

    private void settingBridgeOnAllLine(BridgeInterface bridgeInterface) {
        this.lines.forEach((line) -> line.settingBridgeOnAllPiece(bridgeInterface));
    }

}
