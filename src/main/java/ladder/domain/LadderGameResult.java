package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGameResult {
    private final List<String> result;

    public LadderGameResult(final List<String> result) {
        this.result = new ArrayList<>(result);
    }

    public List<String> getResult() {
        return result;
    }

    public int size() {
        return this.result.size();
    }
}
