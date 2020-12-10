package ladder.domain;

import java.io.PrintWriter;
import java.util.Map;

public class LadderGameResult {
    private final Ladder ladder;

    public LadderGameResult(Ladder ladder) {
        this.ladder = ladder;
    }

    public String getLadderResult(String memberName){
        return ladder.startFrom(memberName);
    }

    public void printLadder(PrintWriter writer) {
        this.ladder.print(writer);
    }

    public Map<String, String> getAllLadderResult() {
        return ladder.startAll();
    }
}
