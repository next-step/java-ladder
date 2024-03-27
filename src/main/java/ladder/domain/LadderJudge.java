package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderJudge {

    private static final String CAN_NOT_BE_INSTANCE_EXCEPTION_MESSAGE
        = "인스턴스화 불가 클래스입니다";

    private LadderJudge() {
        throw new AssertionError(CAN_NOT_BE_INSTANCE_EXCEPTION_MESSAGE);
    }

    public static LadderGameResult judge(List<Participant> participants, List<String> results, LadderResult ladderResult) {
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
