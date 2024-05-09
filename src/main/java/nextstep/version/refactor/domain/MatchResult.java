package nextstep.version.refactor.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MatchResult {

    private final Map<Integer, Integer> result;

    public MatchResult(Map<Integer, Integer> result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchResult)) return false;
        MatchResult that = (MatchResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(result);
    }

    public LadderResult map(Participants participants, Rewards rewards) {
        LinkedHashMap map = new LinkedHashMap<>();

        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            String reward = rewards.get(result.get(i));
            map.put(participant.getName(), reward);
        }
        return new LadderResult(map);
    }
}
