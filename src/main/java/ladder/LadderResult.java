package ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {

    private Map<Integer, Integer> result;

    private LadderResult(Map<Integer, Integer> result) {
        this.result = result;
    }

    public static LadderResult of(int people) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int index = 0; index < people; index++) {
            result.put(index, index);
        }
        return new LadderResult(result);
    }

    public void put(int index, int position) {
        result.put(index, position);
    }

    public int getTarget(int index) {
        return result.get(index);
    }

    public List<Integer> getValues() {
        return new ArrayList<>(result.values());
    }
}
