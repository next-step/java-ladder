package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderGameResult {
    private final List<NodeResult> nodeResults;

    public static LadderGameResult of(List<NodeResult> nodeResults) {
        return new LadderGameResult(nodeResults);
    }

    private LadderGameResult(List<NodeResult> nodeResults) {
        this.nodeResults = Collections.unmodifiableList(nodeResults);
    }
}
