package ladder.app;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGame {
    public void start() {
        Players players = Players.from(InputView.inputPlayerNames());
        Rewards rewards = Rewards.from(InputView.inputRewardNames());

        validatePlayersAndRewards(players, rewards);

        int ladderHeights = InputView.inputLadderHeights();
        Ladder ladder = Ladder.generateByWidthAndHeight(players.numbers(), ladderHeights);

        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);
    }

    public void validatePlayersAndRewards(Players players, Rewards rewards) {
        if (rewards.isSameNumbers(players.numbers())) {
            throw new IllegalArgumentException("Players와 Rewards는 개수가 같아야 합니다.");
        }
    }
}
