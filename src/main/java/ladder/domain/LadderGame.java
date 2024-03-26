package ladder.domain;

import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final LadderJudge ladderJudge;

    public LadderGame(Ladder ladder, List<Participant> participants, List<String> results) {
        this.ladder = ladder;
        this.ladderJudge = new LadderJudge(participants, results);
    }

    public LadderGameResult result() {
        LadderResult result = ladder.result();
        return ladderJudge.judge(result);
    }
}
