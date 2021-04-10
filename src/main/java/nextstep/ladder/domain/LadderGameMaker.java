package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderFactory;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.reward.Rewards;

import java.util.List;

public class LadderGameMaker {

    private final LadderFactory ladderFactory;

    public LadderGameMaker(LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public LadderGame makeRandomLadderGame(
            List<String> playerNames, List<String> rewardStrings, int ladderHeight) {
        validateSize(playerNames, rewardStrings);

        Ladder ladder = ladderFactory.createLadder(ladderHeight, playerNames.size());
        Rewards rewards = Rewards.of(rewardStrings);

        LadderBoard ladderBoard = new LadderBoard(ladder, rewards);
        Players players = Players.of(playerNames);

        return new LadderGame(players, ladderBoard);
    }

    private void validateSize(List<String> playerNames, List<String> rewardStrings) {
        if (playerNames.size() != rewardStrings.size()) {
            throw new IllegalArgumentException("참가자 수만큼의 보상이 필요합니다.");
        }
    }

}
