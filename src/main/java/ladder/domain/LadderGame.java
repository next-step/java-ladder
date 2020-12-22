package ladder.domain;

import ladder.domain.next.NextLadder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private Ladder ladder;

    public LadderGame(String membersString, String resultsString, int height) {
        this(Arrays.asList(membersString.split(",")), Arrays.asList(resultsString.split(",")), height);
    }

    public LadderGame(List<String> members, List<String> results, int height) {
        this.ladder = new NextLadder(members, results, height);
    }

    public LadderGameResult run() {
        Map<LadderMember, LadderResult> ladderResults = ladder.startAll();
        return new LadderGameResult(ladder, ladderResults);
    }

}
