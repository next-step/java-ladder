package nextstep.refactoring.laddergame.engine;

public class LadderGameResultDto {

    private final String playerName;
    private final String reward;

    public LadderGameResultDto(String playerName, String reward) {
        this.playerName = playerName;
        this.reward = reward;
    }

    public static LadderGameResultDto of(LadderGameResult ladderGameResult) {
        return new LadderGameResultDto(ladderGameResult.getPlayer().getName(),
            ladderGameResult.getReward().getRewardString());
    }

    public String playerName() {
        return playerName;
    }

    public String reward() {
        return reward;
    }
}
