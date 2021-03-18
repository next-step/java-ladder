package ladder.domain;

import ladder.LineList;
import ladder.dto.LadderGameRequest;

public class LadderGame {

    private final LineList lineList = new LineList();

    private final PlayerList participatingPlayerList = new PlayerList();

    public LadderGame(LadderGameRequest ladderGameRequest) {
        participatingPlayerList.addBulk(ladderGameRequest.getNames());
        lineList.addBulk(ladderGameRequest.getHeight(), participatingPlayerList.size());
    }

    public LadderBoard ladderBoard() {
        return new LadderBoard(participatingPlayerList, lineList);
    }
}
