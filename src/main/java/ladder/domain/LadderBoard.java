package ladder.domain;

import ladder.dto.LadderGameRequest;

import java.util.List;

public class LadderBoard {

    private final LineList lineList;

    private final PrizeList prizeList;

    public LadderBoard(LineList lineList, PrizeList prizeList) {
        this.lineList = lineList;
        this.prizeList = prizeList;
    }

    public static LadderBoard of(LadderGameRequest ladderGameRequest) {
        LineList lineList = LineList.of(ladderGameRequest);
        PrizeList prizeList = PrizeList.of(ladderGameRequest.prizeList());
        return new LadderBoard(lineList, prizeList);
    }

    public Prize prize(Player player) {
        Position endPosition = lineList.endLadderNumber(player.startPosition());
        return prizeList.prize(endPosition);
    }

    public List<Line> lineList() {
        return lineList.lineList();
    }

    public List<Prize> prizeList() {
        return prizeList.prizeList();
    }
}
