package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {

    private static final int FIRST_INDEX = 0;


    private final Map<Integer, Integer> results;

    public Results(Map<Integer, Integer> results) {
        this.results = results;
    }

    public static Results firstMove(Line line) {
        Map<Integer, Integer> results = new HashMap<>();
        List<Position> positions = line.stepsToPositions();

        for (int i = FIRST_INDEX; i < positions.size(); i++) {
            results.put(i, positions.get(i).move());
        }

        return new Results(results);
    }

    public Results nextMove(Line line) {
        Map<Integer, Integer> newResults = new HashMap<>();
        List<Position> positions = line.stepsToPositions(this);

        for (int i = FIRST_INDEX; i < positions.size(); i++) {
            newResults.put(matchedKeyOfValue(i), positions.get(i).move());
        }

        return new Results(newResults);
    }

    public int matchedKeyOfValue(int value) {
        return results.keySet()
                .stream()
                .filter(key -> results.get(key) == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("나올 수 없는 값입니다."));
    }

    public int getValue(int key) {
        return results.get(key);
    }

    public String matchedResult(int key, LadderInputs reward) {
        return reward.getInput(results.get(key));
    }
}
