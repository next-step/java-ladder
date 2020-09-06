package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResultCalculator {

    private LadderResultCalculator() {}

    public static Map<Integer, Integer> calculate(int playerCount, LadderLine ladderLine) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int playerIndex = 0; playerIndex < playerCount; playerIndex++) {
            map.put(playerIndex, ladderLine.getResultOf(playerIndex));
        }

        return map;
    }
}
