package com.ladder.view;

import com.ladder.model.LadderGame;
import com.ladder.model.Players;
import com.ladder.view.formatter.Formatter;

public class OutputView {

    private final Formatter<Players> userNamesFormatter;
    private final Formatter<LadderGame> ladderFormatter;

    public OutputView(Formatter<Players> userNamesFormatter, Formatter<LadderGame> ladderFormatter) {
        this.userNamesFormatter = userNamesFormatter;
        this.ladderFormatter = ladderFormatter;
    }

    public void printUserName(Players players) {
        System.out.println(userNamesFormatter.format(players));
    }

    public void printLadder(LadderGame ladderGame) {
        System.out.println(ladderFormatter.format(ladderGame));
    }
}
