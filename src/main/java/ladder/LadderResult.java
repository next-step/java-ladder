package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderResult {

    // index, position
    private Map<Integer, Position> result;

    public LadderResult(Map<Integer, Position> result) {
        this.result = result;
    }

    public Position getTarget(int index) {
        return result.get(index);
    }

    public List<Position> getValues() {
        return new ArrayList<>(result.values());
    }
}
