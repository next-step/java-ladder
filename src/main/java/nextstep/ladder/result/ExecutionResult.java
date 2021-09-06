package nextstep.ladder.result;

import java.util.HashMap;
import java.util.Map;

public class ExecutionResult {

    private Map<Integer, Integer> resultMap = new HashMap<>();

    public void put(int participantIndex, int resultIndex) {
        resultMap.put(participantIndex, resultIndex);
    }

    public int get(int participantIndex) {
        return resultMap.get(participantIndex);
    }
}
