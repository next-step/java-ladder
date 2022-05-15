package ladder.app;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGame {
    public static final String ALL = "all";

    private Players players;
    private Rewards rewards;
    private Ladder ladder;

    public void start() {
        players = generatePlayers();
        rewards = generateRewards();
        validatePlayersAndRewards();

        ladder = generateLadder();

        displayLadder();
        displayResult();
    }

    private Players generatePlayers() {
        return Players.from(InputView.inputPlayerNames());
    }

    private Rewards generateRewards() {
        return Rewards.from(InputView.inputRewardNames());
    }

    private void validatePlayersAndRewards() {
        if (!rewards.isSameNumbers(players.numbers())) {
            throw new IllegalArgumentException("Players와 Rewards는 크기가 같아야 합니다.");
        }
    }

    private Ladder generateLadder() {
        int ladderHeights = InputView.inputLadderHeights();
        return Ladder.generateByWidthAndHeight(players.numbers(), ladderHeights);
    }

    private void displayLadder() {
        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);
    }

    private void displayResult() {
        Name name = generateName();

        if (isAll(name)) {
            displayResults();
            return;
        }

        displayResult(name);
        displayResult();
    }

    private Name generateName() {
        return new Name(InputView.inputPlayerName());
    }

    private boolean isAll(Name name) {
        return name.equals(Name.valueOf(ALL));
    }

    private Reward traceLadder(Player player) {
        return rewards.findByPosition(ladder.trace(player));
    }

    private void displayResult(Name name) {
        OutputView.printResult();
        OutputView.printReward(traceLadder(players.findByName(name)));
    }

    private void displayResults() {
        OutputView.printResult();
        this.players.getPlayers()
                .forEach(player -> {
                            OutputView.printPlayerReward(player, traceLadder(player));
                        }
                );
    }
}
