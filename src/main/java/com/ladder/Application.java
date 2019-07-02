package com.ladder;

import com.ladder.model.*;
import com.ladder.view.InputView;
import com.ladder.view.OutputView;
import com.ladder.view.formatter.Formatter;
import com.ladder.view.formatter.LadderFormatter;
import com.ladder.view.formatter.PlayersFormatter;
import com.ladder.view.formatter.RewardsFormatter;

public class Application {

    private static final Formatter<Players> userNamesFormatter = new PlayersFormatter();
    private static final Formatter<LadderGame> ladderFormatter = new LadderFormatter();
    private static final Formatter<Rewards> rewardsFormatter = new RewardsFormatter();
    private static final OutputView outputView = new OutputView(userNamesFormatter, ladderFormatter, rewardsFormatter);

    public static void main(String[] args) {
        Players players = InputView.writeUserNames();
        int numberOfColumns = InputView.askNumberOfColumns();
        Rewards rewards = InputView.writeRewards();

        LadderGame ladderGame = LadderGame.generate(numberOfColumns, players.countOfPlayers());
        PlayReport playReport = ladderGame.play(Result.of(players, rewards));

        outputView.printUserName(players);
        outputView.printLadder(ladderGame);
        outputView.printReward(rewards);

        String searchPlayerName = InputView.writeFindPlayerNameOfWanted();
        outputView.printResult(searchPlayerName, playReport);
    }
}
