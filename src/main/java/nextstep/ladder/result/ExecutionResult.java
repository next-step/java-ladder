package nextstep.ladder.result;

import java.util.HashMap;
import java.util.Map;

public class ExecutionResult {

    private Map<Integer, Integer> resultMap = new HashMap<>();

    public void put(int startIndex, int resultIndex) {
        resultMap.put(startIndex, resultIndex);
    }

    public int get(int startIndex) {
        return resultMap.get(startIndex);
    }
}
