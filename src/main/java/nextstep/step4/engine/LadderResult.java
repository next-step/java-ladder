package nextstep.step4.engine;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    public static final String NEW_LINE = "\n";
    public static final String ALL = "all";
    public static final String INVALID_PARTICIPANT_NAME_MSG = "올바른 참가자가 아닙니다.";
    public Map<String, String> ladderResult = new HashMap<>();

    public void put(String participant, String result) {
        ladderResult.put(participant, result);
    }

    public String result(final String participantName) {
        if (isAll(participantName)) {
            return "";
        }

        invalidParticipantNameCheck(participantName);

        return String.format("%s : %s", participantName, ladderResult.get(participantName) + NEW_LINE);
    }

    private boolean isAll(final String participantName) {
        return ALL.equals(participantName);
    }

    private void invalidParticipantNameCheck(final String participantName) {
        if (isNotParticipant(participantName)) {
            throw new IllegalArgumentException(INVALID_PARTICIPANT_NAME_MSG);
        }
    }

    private boolean isNotParticipant(final String participantName) {
        return !ladderResult.containsKey(participantName);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : this.ladderResult.entrySet()) {
            stringBuilder.append(String.format("%s : %s", entry.getKey(), entry.getValue()) + NEW_LINE);
        }

        return stringBuilder.toString();
    }
}
