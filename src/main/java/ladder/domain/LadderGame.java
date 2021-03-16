package ladder.domain;

import ladder.dto.LadderGameRequest;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final List<Line> lineList = new ArrayList<>();

    private final PlayerList participatingPlayerList = new PlayerList();

    public LadderGame(LadderGameRequest ladderGameRequest) {
        participatingPlayerList.addBulk(ladderGameRequest.getNames());
    }

    public List<Line> getLadderBoard() {
    return null;
    }
}
