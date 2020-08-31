package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final Player player;
    private final Reward reward;
    private final LadderLine ladderLine;
    private final LadderResult ladderResult;

    public Ladder(LadderData ladderData) {
        this.player = ladderData.getPlayer();
        this.reward = ladderData.getReward();
        this.ladderLine = new LadderLine(ladderData.getPlayerCount(), ladderData.getHeight());
        this.ladderResult = new LadderResult();
        setLadderResultData();
    }

    private void setLadderResultData() {
        for (int playerIndex = 0; playerIndex < player.getPlayerCount(); playerIndex++) {
            ladderResult.put(playerIndex, ladderLine.getResultOf(playerIndex));
        }
        ladderResult.freezeData();
    }

    public List<String> getNames() {
        return player.getNames();
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
                player.getPlayerIndex(playerName));
    }

    public List<String> searchAllReward() {
        return player.getNames()
                .stream()
                .map(this::playerAndRewardToString)
                .collect(Collectors.toList());
    }

    private String playerAndRewardToString(String playerName) {
        return playerName + " : " + searchReward(playerName);
    }
}
