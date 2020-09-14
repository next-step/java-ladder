package ladder.refactoring.domain;

import java.util.Map;
import java.util.Set;

public class LadderResult {

    private final Map<Participant, Integer> result;

    public LadderResult(Map<Participant, Integer> result) {
        this.result = result;
    }

    public static LadderResult of(Map<Participant, Integer> result) {
        return new LadderResult(result);
    }

    public int findResultByParticipant(Participant name) {
        return result.get(name);
    }

    public Set<Participant> getAllParticipants() {
        return result.keySet();
    }
}
