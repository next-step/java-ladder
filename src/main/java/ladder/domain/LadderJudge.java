package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderJudge {

    private final List<Participant> participants;
    private final List<String> results;

    private LadderJudge(List<Participant> participants, List<String> results) {
        this.participants = participants;
        this.results = results;
    }

    public static LadderJudge of(List<Participant> participants, List<String> results) {
        List<Participant> unmodifiableParticipants = Collections.unmodifiableList(participants);
        List<String> unmodifiableResults = Collections.unmodifiableList(results);
        return new LadderJudge(unmodifiableParticipants, unmodifiableResults);
    }

    public LadderGameResult judge(LadderResult ladderResult) {
        Map<Participant, String> judgeResult = new HashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            int resultIndex = ladderResult.resultIndexOf(i);
            Participant participant = participants.get(i);
            String result = results.get(resultIndex);
            judgeResult.put(participant, result);
        }
        return LadderGameResult.from(judgeResult);
    }
}
