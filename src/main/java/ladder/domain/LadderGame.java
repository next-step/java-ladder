package ladder.domain;

import ladder.util.StringUtil;

public class LadderGame {
    private final DirectionMakingStrategy directionMakingStrategy;

    public LadderGame(DirectionMakingStrategy directionMakingStrategy) {
        this.directionMakingStrategy = directionMakingStrategy;
    }

    public Result play(String playerNames, int ladderHeight) {
        Players players = new Players(StringUtil.split(playerNames));
        Ladders ladders = Ladders.initLadders(new LadderWidth(players.size()), new LadderHeight(ladderHeight), directionMakingStrategy);
        return new Result(players, ladders);
    }
}