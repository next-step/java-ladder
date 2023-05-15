package nextstep.ladder.domain;

import java.util.Map;
import java.util.Optional;

public class LadderResults {
    private final Map<Participant, LadderResult> ladderResults;

    public LadderResults(Map<Participant, LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public LadderResult getResultForParticipant(Participant participant) {
        return Optional.ofNullable(ladderResults.get(participant))
                .orElseThrow(() -> new IllegalArgumentException(participant.getName() + " 참가자가 존재하지 않습니다."));
    }

    public Map<Participant, LadderResult> getAllResults() {
        return ladderResults;
    }

}
