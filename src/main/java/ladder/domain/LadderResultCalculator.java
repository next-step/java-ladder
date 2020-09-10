package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResultCalculator {

    private LadderResultCalculator() {}

    public static Map<Integer, Integer> calculate(int playerCount, Ladder ladder) {

        Map<Integer, Integer> map = new HashMap<>();
        LadderLine ladderLine = ladder.getLadderLine();

        for (int playerIndex = 0; playerIndex < playerCount; playerIndex++) {
            map.put(playerIndex, ladderLine.getResultOf(playerIndex));
        }

        return map;
    }
}
