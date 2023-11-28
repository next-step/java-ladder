package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    public static final String EMPTY_PARTICIPANT_MSG = "없는 참가자 입니다.";
    public static final String NEW_LINE = "\n";
    private final Map<Participant, String> ladderResult = new HashMap<>();

    public LadderResult() {
    }

    public void put(final Participant participant, final String result) {
        ladderResult.put(participant, result);
    }

    public String participantResult() {
        return toString();
    }

    public String participantResult(Participant participant) {
        if (isEmptyParticipant(participant)) {
            throw new IllegalArgumentException(EMPTY_PARTICIPANT_MSG);
        }

        return this.ladderResult.get(participant).toString();
    }

    private boolean isEmptyParticipant(final Participant participant) {
        return !this.ladderResult.containsKey(participant);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Participant, String> entry : this.ladderResult.entrySet()) {
            stringBuilder.append(String.format("%s : %s", entry.getKey(), entry.getValue()) + NEW_LINE);
        }

        return stringBuilder.toString();
    }

}
