package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final LadderData ladderData;
    private final LadderLine ladderLine;
    private final LadderResult ladderResult;

    public Ladder(LadderData ladderData) {
        this.ladderData = ladderData;
        this.ladderLine = new LadderLine(ladderData.getPlayerCount(), ladderData.getHeight());
        this.ladderResult = new LadderResult();
        setLadderResultData();
    }

    private void setLadderResultData() {
        for (int player = 0; player < ladderData.getPlayerCount(); player++) {
            ladderResult.put(player, ladderLine.getResultOf(player));
        }
    }

    public List<String> getNames() {
        return ladderData.getPlayerNames();
    }

    public List<String> getRewards() {
        return ladderData.getRewards();
    }

    public List<String> getLadderLinesString() {
        return ladderLine.toStringList();
    }

    public String searchReward(String playerName) {
        return ladderData.getReward(getRewardIndex(playerName));
    }

    private int getRewardIndex(String playerName) {
        return ladderResult.searchRewardIndex(
                ladderData.getPlayerIndex(playerName));
    }

    public List<String> searchAllReward() {
        return ladderData.getPlayerNames()
                .stream()
                .map(this::playerAndReward)
                .collect(Collectors.toList());
    }

    private String playerAndReward(String playerName) {
        return playerName + " : " + searchReward(playerName);
    }
}
