package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Results {

    private Map<Integer, Result> results;

    public Results(Map<Integer, Result> results) {
        this.results = results;
    }

    public static Results init(LadderInputs participants) {
        Map<Integer, Result> results = new HashMap<>();

        for (int i = 0; i < participants.countOfInputs(); i++) {
            results.put(i, new Result(i));
        }

        return new Results(results);
    }

    public Result updateValue(int index, int move) {
        for (int key : results.keySet()) {
            if (results.get(key).isSameIndex(index)) {
                return results.get(key).move(move);
            }
        }

        throw new IllegalArgumentException("나올 수 없는 값입니다.");
    }

    public Integer equalValueKey(int index) {
        for (int key : results.keySet()) {
            if (results.get(key).isSameIndex(index)) {
                return key;
            }
        }

        throw new IllegalArgumentException("나올 수 없는 값입니다.");
    }

}
