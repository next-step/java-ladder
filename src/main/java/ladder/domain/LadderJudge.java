package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderJudge {

    private final List<Participant> participants;
    private final List<String> results;

    public LadderJudge(List<Participant> participants, List<String> results) {
        this.participants = participants;
        this.results = results;
    }

    public LadderGameResult judge(LadderResult ladderResult) {
        Map<Participant, String> judgeResult = new HashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            int resultIndex = ladderResult.resultIndexOf(i);
            Participant participant = participants.get(i);
            String result = results.get(resultIndex);
            judgeResult.put(participant, result);
        }
        return new LadderGameResult(judgeResult);
    }
}
