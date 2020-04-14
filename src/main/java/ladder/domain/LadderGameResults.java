package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderGameResults {
    private static final String ALL = "all";

    private final List<NodeResult> nodeResults;

    public static LadderGameResults of(List<NodeResult> nodeResults) {
        return new LadderGameResults(nodeResults);
    }

    private LadderGameResults(List<NodeResult> nodeResults) {
        this.nodeResults = Collections.unmodifiableList(nodeResults);
    }

    public List<NodeResult> getNodeResults(String userName) {
        if (ALL.equals(userName)) {
            return nodeResults;
        }
        return Collections.singletonList(nodeResults.stream()
                .filter(nodeResult -> nodeResult.matchUser(User.of(userName)))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new));
    }
}
