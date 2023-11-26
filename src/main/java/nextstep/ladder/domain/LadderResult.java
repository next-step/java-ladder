package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private final Map<Participant, String> ladderResult = new HashMap<>();

    public LadderResult() {
    }

    public void put(final Participant participant, final String result) {
        ladderResult.put(participant, result);
    }

    @Override
    public String toString() {
        return ladderResult.toString();
    }
}
