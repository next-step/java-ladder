package ladder;

import java.io.PrintWriter;

public class LadderGameResult {
    private final Ladder ladder;

    public LadderGameResult(Ladder ladder) {
        this.ladder = ladder;
    }

    public void printLadder(PrintWriter writer) {
        this.ladder.print(writer);
    }
}
