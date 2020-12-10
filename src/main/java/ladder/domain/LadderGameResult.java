package ladder.domain;

import java.io.PrintWriter;
import java.util.Map;

public class LadderGameResult {
    private final Ladder ladder;
    private final Map<String, String> ladderResults;

    public LadderGameResult(Ladder ladder, Map<String, String> ladderResults) {
        this.ladder = ladder;
        this.ladderResults = ladderResults;
    }

    public String getLadderResult(String memberName){
        return ladderResults.get(memberName);
    }

    public void printLadder(PrintWriter writer) {
        this.ladder.print(writer);
    }

    public Map<String, String> getAllLadderResult() {
        return ladderResults;
    }
}
