package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private static final String ALL_USER_KEY = "all";
    private final List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public List<LadderResult> getUserResult(String key) {
        if (ALL_USER_KEY.equals(key)) {
            return this.ladderResults;
        }
        return ladderResults.stream()
                .filter(ladderResult -> ladderResult.getUser().getName().equals(key))
                .collect(Collectors.toList());
    }

}
