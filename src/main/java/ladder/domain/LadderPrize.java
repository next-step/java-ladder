package ladder.domain;

import java.util.List;

public class LadderPrize {

    private final List<String> result;

    public LadderPrize(List<String> result) {
        this.result = result;
    }

    public List<String> getResult() {
        return result;
    }

    public int size() {
        return this.result.size();
    }
}
