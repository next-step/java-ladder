package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Results {

    private static final int FIRST_INDEX = 0;

    private Map<Integer, Result> results;

    public Results(Map<Integer, Result> results) {
        this.results = results;
    }

    public static Results init(LadderInputs participants) {
        Map<Integer, Result> results = new HashMap<>();

        for (int i = FIRST_INDEX; i < participants.countOfInputs(); i++) {
            results.put(i, new Result(i));
        }

        return new Results(results);
    }

    public Result updateValue(int index, int move) {
        return results.keySet()
                .stream()
                .filter(key -> results.get(key).isSameIndex(index))
                .map(key -> results.get(key).move(move))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("나올 수 없는 값입니다."));
    }

    public Integer equalValueKey(int index) {
        return results.keySet()
                .stream()
                .filter(key -> results.get(key).isSameIndex(index))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("나올 수 없는 값입니다."));
    }

    public String matchResult(int key, LadderInputs reward) {
        return reward.getInput(results.get(key).getResult());
    }
}
