package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderGameResult {
    private static final String ALL = "all";

    private final List<NodeResult> nodeResults;

    public static LadderGameResult of(List<NodeResult> nodeResults) {
        return new LadderGameResult(nodeResults);
    }

    private LadderGameResult(List<NodeResult> nodeResults) {
        this.nodeResults = Collections.unmodifiableList(nodeResults);
    }

    public List<NodeResult> getNodeResults(String userName) {
        if (userName.equals(ALL)) {
            return nodeResults;
        }
        return Collections.singletonList(nodeResults.stream()
                .filter(nodeResult -> nodeResult.matchUser(User.of(userName)))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new));
    }
}
