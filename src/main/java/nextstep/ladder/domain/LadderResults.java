package nextstep.ladder.domain;

import java.util.Map;
import java.util.Optional;

public class LadderResults {
    private final Map<Name, LadderResult> ladderResults;

    public LadderResults(Map<Name, LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public LadderResult getResultForParticipant(Name name) {
        return Optional.ofNullable(ladderResults.get(name))
                .orElseThrow(() -> new IllegalArgumentException(name.getName() + " 참가자가 존재하지 않습니다."));
    }

    public Map<Name, LadderResult> getAllResults() {
        return ladderResults;
    }
}
