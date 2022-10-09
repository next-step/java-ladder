package nextstep.laddergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> board;

    Ladder(int width, int height, BridgeInterface bridgeInterface) {
        this.board = Collections.unmodifiableList(getLadderTemplate(width, height));
        drawBridgeAtAllLine(bridgeInterface);
    }

    public List<Line> getBoard() {
        return board;
    }

    private List<Line> getLadderTemplate(int width, int height) {
        List<Line> ladderTemplate = new ArrayList<>();
        for (int innerIndex = 0; innerIndex < height; innerIndex++) {
            ladderTemplate.add(new Line(width));
        }
        return ladderTemplate;
    }

    private void drawBridgeAtAllLine(BridgeInterface bridgeInterface) {
        for (Line line : this.board) {
            line.drawBridgeAtAllPiece(bridgeInterface);
        }
    }

}
