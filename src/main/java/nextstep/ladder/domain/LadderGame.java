package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private static class LadderGameHolder {
        private static final LadderGame LADDER_GAME = new LadderGame();
    }

    public static LadderGame getInstance() {
        return LadderGameHolder.LADDER_GAME;
    }

    public Map<Name, String> gamePlay(Players players, Ladder ladder, ExecutionResult executionResult) {
        Map<Name, String> result = new LinkedHashMap<>();
        for (int i = 0; i < players.size(); i++) {
            result.put(players.getPlayer(i), executionResult.get(playerResult(ladder, i)));
        }
        return result;
    }

    private int playerResult(Ladder ladder, int idx) {
        for (Line line : ladder.getLadder()) {
            idx = idx + Move.of(line.get(idx - 1), line.get(idx)).move();
        }
        return idx;
    }


}
