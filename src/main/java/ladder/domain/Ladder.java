package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import ladder.ui.LadderDataInput;

public class Ladder {

    private final Player player;
    private final Reward reward;
    private final LadderLine ladderLine;
    private final LadderResult ladderResult;

    public Ladder(LadderDataInput ladderData) {
        this(ladderData.getPlayer(), ladderData.getReward(), ladderData.getHeight());
    }

    public Ladder(Player player, Reward reward, int height) {
        this.player = player;
        this.reward = reward;
        this.ladderLine = new LadderLine(player.getPlayerCount(), height);
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
