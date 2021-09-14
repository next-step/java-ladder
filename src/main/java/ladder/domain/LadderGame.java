package ladder.domain;

import ladder.util.StringUtil;

public class LadderGame {
    private final DirectionMakingStrategy directionMakingStrategy;

    public LadderGame(DirectionMakingStrategy directionMakingStrategy) {
        this.directionMakingStrategy = directionMakingStrategy;
    }

    public Result play(String playerNames, String inputPlayResults, int ladderHeight) {
        Players players = new Players(StringUtil.split(playerNames));
        PlayResults playResults = new PlayResults(StringUtil.split(inputPlayResults));
        Ladders ladders = Ladders.initLadders(new LadderWidth(players.size()), new LadderHeight(ladderHeight), directionMakingStrategy);
        LadderResult ladderResult = ladders.play(players, playResults);
        return new Result(players, ladders, playResults, ladderResult);
    }
}