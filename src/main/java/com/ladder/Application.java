package com.ladder;

import com.ladder.model.*;
import com.ladder.view.InputView;
import com.ladder.view.OutputView;
import com.ladder.view.formatter.Formatter;
import com.ladder.view.formatter.LadderFormatter;
import com.ladder.view.formatter.PlayersFormatter;

public class Application {

    private static final Formatter<Players> userNamesFormatter = new PlayersFormatter();
    private static final Formatter<Ladder> ladderFormatter = new LadderFormatter();
    private static final OutputView outputView = new OutputView(userNamesFormatter, ladderFormatter);

    public static void main(String[] args) {
        Players players = InputView.writeUserNames();
        int numberOfColumns =InputView.askNumberOfColumns();

        Ladder ladder = Ladder.generate(numberOfColumns, players.countOfPlayers());

        outputView.printUserName(players);
        outputView.printLadder(ladder);
    }
}
