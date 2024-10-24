package laddergame.v2.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private final List<String> results;

    public LadderResult(List<String> results) {
        this.results = results;
    }

    public String get(int position){
        return results.get(position);
    }

    public List<String> getResults() {
        return new ArrayList<>(results);
    }
}
