package ladder.domain;

import java.util.Arrays;
import java.util.List;

public class LadderGame {

    private Ladder ladder;

    public LadderGame(String membersString, String resultsString, int height) {
        this(Arrays.asList(membersString.split(",")), Arrays.asList(resultsString.split(",")), height);
    }

    public LadderGame(List<String> members, List<String> results, int height) {
        this.ladder = new DefaultLadder(members, results, height);
    }

    public LadderGameResult run() {
        return new LadderGameResult(ladder);
    }

}
