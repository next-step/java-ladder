package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveResult {

    private final Map<Integer, Integer> moveResult = new HashMap<>();

    public void put(int playerIndex, int winningItemIndex) {
        moveResult.put(playerIndex, winningItemIndex);
    }

    public int getWinningItemIndex(int playerIndex) {
        return moveResult.get(playerIndex);
    }

    public LadderGameResult map(Players players, WinningItems winningItems) {
        List<PlayerWinnings> playerWinnings = new ArrayList<>();

        moveResult.keySet().forEach(
                k -> playerWinnings.add(
                        new PlayerWinnings(players.getPlayer(k), winningItems.getWinningItem(moveResult.get(k))))
        );

        return new LadderGameResult(playerWinnings);
    }
}
