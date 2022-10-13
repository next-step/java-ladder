package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Gamer> gamers;
    private final List<Line> board;

    public Ladder(List<Gamer> gamers, Height height, BridgeInterface bridgeInterface) {
        this.gamers = gamers;
        this.board = Collections.unmodifiableList(getLadderTemplate(gamers.size(), height.getLadderHeight()));
        settingBridgeOnAllLine(bridgeInterface);
    }

    public List<Gamer> getGamers() {
        return gamers;
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

    private void settingBridgeOnAllLine(BridgeInterface bridgeInterface) {
        this.board.forEach((line) -> line.settingBridgeOnAllPiece(bridgeInterface));
    }

}
