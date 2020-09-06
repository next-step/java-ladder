package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final Participants participants;
    private final Reward reward;
    private final LadderLine ladderLine;
    private final LadderResult ladderResult;

    public Ladder(Participants participants, Reward reward, int height) {
        this.participants = participants;
        this.reward = reward;
        this.ladderLine = new LadderLine(participants.getPlayerCount(), height);
        this.ladderResult = new LadderResult(
            LadderResultCalculator.calculate(participants.getPlayerCount(), ladderLine));
    }

    public List<String> getNames() {
        return participants.getNames();
    }

    public List<String> getRewardNames() {
        return reward.getNames();
    }

    public List<String> getLadderLinesString() {
        return ladderLine.toStringList();
    }

    public String searchReward(String playerName) {
        return reward.get(getRewardIndex(playerName));
    }

    private int getRewardIndex(String playerName) {
        return ladderResult.searchRewardIndex(
            participants.getPlayerIndex(playerName));
    }

    public List<String> searchAllReward() {
        return participants.getNames()
                          .stream()
                          .map(this::playerAndRewardToString)
                          .collect(Collectors.toList());
    }

    private String playerAndRewardToString(String playerName) {
        return playerName + " : " + searchReward(playerName);
    }
}
