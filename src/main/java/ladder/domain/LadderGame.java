package ladder.domain;

import ladder.dto.LadderBoard;
import ladder.dto.LadderGameRequest;

public class LadderGame {

    private final LineList lineList = new LineList();

    private final PlayerList participatingPlayerList = new PlayerList();

    public LadderGame(LadderGameRequest ladderGameRequest) {
        participatingPlayerList.addBulk(ladderGameRequest.names());
        lineList.addBulk(ladderGameRequest.height(), participatingPlayerList.size());
    }

    public LadderBoard ladderBoard() {
        return new LadderBoard(participatingPlayerList, lineList);
    }
}
