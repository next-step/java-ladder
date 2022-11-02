package ladder;

import ladder.domain.Ladder;
import ladder.domain.Rewards;

public class LadderGamePlayer {

    private static final String RESULT_ALL_COMMAND = "all";

    public LadderResultDto play(LadderGameData gameData, String command) {
        Ladder ladder = gameData.getLadder();
        Rewards rewards = gameData.getRewards();

        if (RESULT_ALL_COMMAND.equals(command)) {
            return addAllResult(ladder, rewards);
        }
        return addSingleResult(command, ladder, rewards);
    }

    private LadderResultDto addAllResult(Ladder ladder, Rewards rewards) {
        LadderResultDto resultDto = new LadderResultDto();
        ladder.getNames()
                .forEach(name ->
                        resultDto.addResult(name, rewards.getReward(ladder.getEndPoint(name))));
        return resultDto;
    }

    private LadderResultDto addSingleResult(String command, Ladder ladder, Rewards rewards) {
        LadderResultDto resultDto = new LadderResultDto();
        resultDto.addResult(command, rewards.getReward(ladder.getEndPoint(command)));
        return resultDto;
    }

}
