package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class MoveResult {

    private final Map<Integer, Integer> moveResult = new HashMap<>();

    public void put(int playerIndex, int winningItemIndex) {
        moveResult.put(playerIndex, winningItemIndex);
    }

    public int getWinningItemIndex(int playerIndex) {
        return moveResult.get(playerIndex);
    }
}
