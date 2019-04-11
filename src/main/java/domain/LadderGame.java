package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderGame {
    private Ladder ladder;
    private Map<Player, Result> ladderGameResult;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public LadderGameResult playGame(Players players, Results results) {
        List<Integer> finalPositions = new ArrayList<>();
        for (int i = 0; i < players.getNumber(); i ++){
            finalPositions.add(ladder.move(i));
        }

        ladderGameResult = new HashMap<>();
        IntStream.range(0, players.getNumber())
                 .forEach(i -> ladderGameResult.put(players.get(i),
                            results.get(finalPositions.get(i))));
        return new LadderGameResult(ladderGameResult);
    }
}
