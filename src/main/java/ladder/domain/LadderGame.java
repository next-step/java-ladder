package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private GameInfo gameInfo;
    private Lines lines;

    public LadderGame(GameInfo gameInfo, Lines lines) {
        this.gameInfo = gameInfo;
        this.lines = lines;
    }

    public LadderResult createResult() {
        Map<Integer, Integer> positionGoals = new HashMap<>();
        for (int i = 0; i < gameInfo.getLadderWidth(); i++) {
            positionGoals.put(i, getLines().move(i));
        }

        return new LadderResult(positionGoals);
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public Lines getLines() {
        return lines;
    }
}
