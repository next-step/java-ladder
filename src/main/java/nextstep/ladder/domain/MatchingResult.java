package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchingResult {
    private final Map<Integer, Integer> matchingResult = new HashMap<>();

    public MatchingResult() {
    }

    public void mappingIDX(int memberIDX, int rewardIDX) {
        matchingResult.put(memberIDX, rewardIDX);
    }

    public LadderResult map(JoinMembers joinMembers, Rewards rewards) {
        LadderResult ladderResult = new LadderResult();
        matchingResult.forEach((memberIDX, rewardIDX) -> {
            ladderResult.addResult(joinMembers.getMember(memberIDX), rewards.getReward(rewardIDX));
        });
        return ladderResult;
    }
}
