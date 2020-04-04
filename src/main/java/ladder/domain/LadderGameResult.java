package ladder.domain;

import java.util.List;

public class LadderGameResult {

    private final List<String> result;

    public LadderGameResult(List<String> result) {
        this.result = result;
    }

    public List<String> getResult() {
        return result;
    }

    public int size() {
        return this.result.size();
    }
}
