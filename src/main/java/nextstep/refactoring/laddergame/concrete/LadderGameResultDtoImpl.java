package nextstep.refactoring.laddergame.concrete;

import nextstep.refactoring.laddergame.engine.LadderGameResult;
import nextstep.refactoring.laddergame.engine.LadderGameResultDto;

public class LadderGameResultDtoImpl implements LadderGameResultDto {

    private final String playerName;
    private final String reward;

    public LadderGameResultDtoImpl(String playerName, String reward) {
        this.playerName = playerName;
        this.reward = reward;
    }

    public static LadderGameResultDto of(LadderGameResult ladderGameResult) {
        return new LadderGameResultDtoImpl(ladderGameResult.getPlayer().getName(),
            ladderGameResult.getReward().getRewardString());
    }

    @Override
    public String playerName() {
        return playerName;
    }

    @Override
    public String reward() {
        return reward;
    }
}
