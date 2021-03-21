package ladder.domain;

import ladder.dto.LadderBoardDto;
import ladder.dto.LadderGameRequest;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final LadderBoard ladderBoard;

    private final PlayerList participatingPlayerList = new PlayerList();

    public LadderGame(LadderGameRequest ladderGameRequest) {
        participatingPlayerList.addBulk(ladderGameRequest.names());
        this.ladderBoard = new LadderBoard(ladderGameRequest);
    }

    public LadderBoardDto ladderBoard() {
        return new LadderBoardDto(participatingPlayerList, ladderBoard);
    }
}
