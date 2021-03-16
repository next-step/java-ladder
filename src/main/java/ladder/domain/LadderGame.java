package ladder.domain;

import ladder.dto.LadderGameRequest;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final List<Line> lineList = new ArrayList<>();

    private final PlayerList participatingPlayerList = new PlayerList();

    public LadderGame(LadderGameRequest ladderGameRequest) {
        participatingPlayerList.addBulk(ladderGameRequest.getNames());
        for (int i = 0; i < ladderGameRequest.getHeight(); i++) {
            lineList.add(new Line(participatingPlayerList.size()));
        }
    }

    public List<Line> getLadderBoard() {
        return lineList;
    }
}
