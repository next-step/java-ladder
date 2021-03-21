package ladder.domain;

import ladder.dto.LadderGameRequest;

import java.util.Arrays;
import java.util.List;

public class LadderBoard {

    private final LineList lineList;

    private final LadderList ladderList;

    public LadderBoard(LadderGameRequest ladderGameRequest) {
        this.lineList = new LineList();
        this.ladderList = new LadderList();
    }

    public LadderBoard(LineList lineList, LadderList ladderList) {
        this.lineList = lineList;
        this.ladderList = ladderList;
    }

    public Prize prize(Player player) {
        player.move(lineList);
        return ladderList.prize(player.ladderNumber());
    }

    public List<Line> lineList() {
        return lineList.lineList();
    }
}
