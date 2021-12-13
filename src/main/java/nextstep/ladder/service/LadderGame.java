package nextstep.ladder.service;

import java.util.LinkedHashMap;
import java.util.Map;
import nextstep.ladder.domain.Category;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Move;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Players;

public class LadderGame {

    private static final int LEFT_INDEX = 1;

    private static class LadderGameHolder {

        private static final LadderGame LADDER_GAME = new LadderGame();
    }

    public static LadderGame getInstance() {
        return LadderGameHolder.LADDER_GAME;
    }

    public Map<Name, Name> gamePlay(Players players, Ladder ladder, Category category) {
        Map<Name, Name> result = new LinkedHashMap<>();
        final int SIZE = players.size();

        for (int idx = 0; idx < SIZE; idx++) {
            result.put(players.getPlayer(idx), category.get(playerResult(ladder, idx)));
        }
        return result;
    }

    private int playerResult(Ladder ladder, int idx) {
        for (Line line : ladder.getLadder()) {
            idx = idx + Move.of(line.get(idx - LEFT_INDEX), line.get(idx)).move();
        }
        return idx;
    }


}
