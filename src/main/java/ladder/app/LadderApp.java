package ladder.app;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGame;
import ladder.domain.player.Name;
import ladder.domain.player.Players;
import ladder.domain.result.Result;
import ladder.domain.result.Results;
import ladder.domain.reward.Rewards;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApp {
    public static final String ALL = "all";

    public void start() {
        Players players = generatePlayers();
        Rewards rewards = generateRewards();
        validatePlayersAndRewards(players, rewards);

        Ladder ladder = generateLadder(players.numbers());

        displayPlayers(players);
        displayLadder(ladder);
        displayRewards(rewards);

        play(LadderGame.of(ladder, rewards), players);
    }

    private void play(LadderGame ladderGame, Players players) {
        Results results = ladderGame.play(players);
        displayResults(results);
    }

    private Players generatePlayers() {
        return Players.from(InputView.inputPlayerNames());
    }

    private Rewards generateRewards() {
        return Rewards.from(InputView.inputRewardNames());
    }

    private void validatePlayersAndRewards(Players players, Rewards rewards) {
        if (!rewards.isSameNumbers(players.numbers())) {
            throw new IllegalArgumentException("Players와 Rewards는 크기가 같아야 합니다.");
        }
    }

    private Ladder generateLadder(int width) {
        int ladderHeights = InputView.inputLadderHeights();
        return Ladder.generateByWidthAndHeight(width, ladderHeights);
    }

    private void displayPlayers(Players players) {
        OutputView.printPlayers(players);
    }

    private void displayLadder(Ladder ladder) {
        OutputView.printLadder(ladder);
    }

    private void displayRewards(Rewards rewards) {
        OutputView.printRewards(rewards);
    }

    private void displayResults(Results results) {
        Name name = generateName();

        if (isAll(name)) {
            displayAllResults(results);
            return;
        }

        displayResult(results.findByPlayerName(name));
        displayResults(results);
    }

    private Name generateName() {
        return new Name(InputView.inputPlayerName());
    }

    private boolean isAll(Name name) {
        return name.equals(Name.valueOf(ALL));
    }

    private void displayResult(Result result) {
        OutputView.printResult();
        OutputView.printResult(result);
    }

    private void displayAllResults(Results results) {
        OutputView.printResult();
        OutputView.printResults(results);
    }
}
