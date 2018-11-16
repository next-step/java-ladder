package domain.ladder;

import java.util.List;

public class LadderResult {
    private List<String> results;

    LadderResult(List<String> result) {
        this.results = result;
    }

    public List<String> getResults() {
        return results;
    }
}
