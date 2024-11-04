package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {
    private static final String ALL_PARTICIPANT = "all";

    private final Map<String, String> participantOutcomes;

    public LadderResult() {
        participantOutcomes = new HashMap<>();
    }

    public String getOutcomeForParticipant(String participantNameForOutcome) {
        if (participantNameForOutcome.equals(ALL_PARTICIPANT)) {
            return participantOutcomes.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + " : " + entry.getValue())
                    .collect(Collectors.joining("\n"));
        }

        if (participantOutcomes.get(participantNameForOutcome) == null) {
            throw new NullPointerException("존재하지 않는 참가자입니다.");
        }

        return participantOutcomes.get(participantNameForOutcome);
    }

    public Map<String, String> getParticipantOutcomes() {
        return participantOutcomes;
    }

}
