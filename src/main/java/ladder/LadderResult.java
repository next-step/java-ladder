package ladder;

public class LadderResult {
    private String playerName;
    private LadderRewardType ladderRewardType;

    public LadderResult(String playerName, LadderRewardType ladderRewardType) {
        this.playerName = playerName;
        this.ladderRewardType = ladderRewardType;
    }

    public String getPlayerName() {
        return playerName;
    }

    public LadderRewardType getLadderRewardType() {
        return ladderRewardType;
    }
}
