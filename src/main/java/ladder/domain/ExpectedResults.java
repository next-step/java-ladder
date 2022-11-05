package ladder.domain;

import java.util.Collections;
import java.util.List;

public class ExpectedResults {
    private final List<ExpectedResult> expectedResults;

    public ExpectedResults(List<ExpectedResult> expectedResults) {
        this.expectedResults = expectedResults;
    }

    public List<ExpectedResult> getExpectedResults() {
        return Collections.unmodifiableList(expectedResults);
    }
}
