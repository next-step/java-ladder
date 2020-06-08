package ladder.step4.domain;

import ladder.step4.exception.NotParticipantException;

import java.util.Map;

public class LadderGame {

    private final Map<Participant, LadderResult> resultMap;

    private LadderGame(Map<Participant, LadderResult> resultMap) {
        this.resultMap = resultMap;
    }

    public static LadderGame of(Map<Participant, LadderResult> resultMap) {
        return new LadderGame(resultMap);
    }

    public LadderResult getResult(Participant participant) {
        validate(participant);
        return resultMap.get(participant);
    }

    public LadderResult getResultOfString(String participant) {
        return getResult(Participant.valueOf(participant));
    }

    private void validate(Participant participant) {
        if (resultMap.get(participant) == null) {
            throw new NotParticipantException(participant);
        }
    }
}
