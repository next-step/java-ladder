package ladder;

public class LadderResult {
    private String playerName;
    private LadderReward ladderReward;

    public LadderResult(String playerName, LadderReward ladderReward) {
        this.playerName = playerName;
        this.ladderReward = ladderReward;
    }

    public String getPlayerName() {
        return playerName;
    }

    public LadderReward getLadderReward() {
        return ladderReward;
    }
}
