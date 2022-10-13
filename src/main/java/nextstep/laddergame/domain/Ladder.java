package nextstep.laddergame.domain;

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

    private List<Line> getLadderTemplate(int width, int height) {
        List<Line> ladderTemplate = new ArrayList<>();
        for (int innerIndex = 0; innerIndex < height; innerIndex++) {
            ladderTemplate.add(new Line(width));
        }
        return ladderTemplate;
    }

    private void settingBridgeOnAllLine(BridgeInterface bridgeInterface) {
        this.lines.forEach((line) -> line.settingBridgeOnAllPiece(bridgeInterface));
    }

}
