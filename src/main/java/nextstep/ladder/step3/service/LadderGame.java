package nextstep.ladder.step3.service;

import nextstep.ladder.step3.domain.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private static final int LEFT_INDEX = 1;

    private LadderGame() {
    }

    public static Map<Name, Name> gamePlay(Players players, Ladder ladder, Category category) {
        Map<Name, Name> result = new LinkedHashMap<>();
        final int SIZE = players.size();

        for (int idx = 0; idx < SIZE; idx++) {
            result.put(players.getPlayer(idx), category.get(playerResult(ladder, idx)));
        }
        return result;
    }

    private static int playerResult(Ladder ladder, int idx) {
        for (Line line : ladder.getLadder()) {
            idx = idx + Move.of(line.get(idx - LEFT_INDEX), line.get(idx)).move();
        }
        return idx;
    }

}
