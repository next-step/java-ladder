package ladder.domain;

import java.io.PrintWriter;
import java.util.Map;

public class LadderGameResult {
    private final Ladder ladder;
    private final Map<LadderMember, LadderResult> ladderResults;

    public LadderGameResult(Ladder ladder, Map<LadderMember, LadderResult> ladderResults) {
        this.ladder = ladder;
        this.ladderResults = ladderResults;
    }

    public LadderResult getLadderResult(String memberName){
        return ladderResults.get(new LadderMember(memberName));
    }

    public void printLadder(PrintWriter writer) {
        this.ladder.print(writer);
    }

    public Map<LadderMember, LadderResult> getAllLadderResult() {
        return ladderResults;
    }
}
