package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class LineResults {

    private final List<String> lineResults;

    public LineResults(List<String> results) {
        this.lineResults = results;
    }

    public String match(int position) {
        return lineResults.get(position);
    }

    public List<String> getValue() {
        return Collections.unmodifiableList(lineResults);
    }
}
