package ladder.domain;

import ladder.dto.LadderGameRequest;

import java.util.List;

public class LadderBoard {

    private final LineList lineList;

    private final LadderList ladderList;

    public LadderBoard(LineList lineList, LadderList ladderList) {
        this.lineList = lineList;
        this.ladderList = ladderList;
    }

    public static LadderBoard of(LadderGameRequest ladderGameRequest) {
        LineList lineList = LineList.of(ladderGameRequest);
        LadderList ladderList = LadderList.of(ladderGameRequest.prizeList());
        return new LadderBoard(lineList, ladderList);
    }

    public Prize prize(Player player) {
        player.move(lineList);
        return ladderList.prize(player.ladderNumber());
    }

    public List<Line> lineList() {
        return lineList.lineList();
    }

    public List<Ladder> ladderList() {
        return ladderList.ladderList();
    }
}
