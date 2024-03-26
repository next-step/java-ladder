package ladder.domain;

import java.util.Map;

public class LadderGameResult {

    private final Map<Participant, String> judgeResult;

    public LadderGameResult(Map<Participant, String> judgeResult) {
        this.judgeResult = judgeResult;
    }

    public String get(Participant participant) {
        return judgeResult.get(participant);
    }
}
