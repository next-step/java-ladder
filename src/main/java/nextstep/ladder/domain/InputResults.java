package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class InputResults {
    private List<String> results;

    public InputResults(List<String> results) {
        this.results = results;
    }

    public String getResult(int i) {
        return results.get(i);
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }

   
}
