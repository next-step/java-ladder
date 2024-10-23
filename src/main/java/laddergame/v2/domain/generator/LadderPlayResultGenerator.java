package laddergame.v2.domain.generator;

import laddergame.v2.domain.LadderPlayResult;
import laddergame.v2.domain.LadderResult;
import laddergame.v2.domain.Player;
import laddergame.v2.domain.Players;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderPlayResultGenerator implements PlayResultGenerator {

    private final LadderResult ladderResult;

    public LadderPlayResultGenerator(LadderResult ladderResult) {
        this.ladderResult = ladderResult;
    }

    @Override
    public LadderPlayResult generate(Players players, List<Integer> finalPositions) {
        Map<Player, String> results = new HashMap<Player, String>();
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            int finalPosition = finalPositions.get(i);
            String result = ladderResult.get(finalPosition);
            results.put(player, result);
        }
        return new LadderPlayResult(results);
    }
}
