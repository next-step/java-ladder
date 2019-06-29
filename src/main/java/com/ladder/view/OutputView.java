package com.ladder.view;

import com.ladder.model.Ladder;
import com.ladder.model.Players;
import com.ladder.view.formatter.Formatter;

public class OutputView {

    private final Formatter<Players> userNamesFormatter;
    private final Formatter<Ladder> ladderFormatter;

    public OutputView(Formatter<Players> userNamesFormatter, Formatter<Ladder> ladderFormatter) {
        this.userNamesFormatter = userNamesFormatter;
        this.ladderFormatter = ladderFormatter;
    }

    public void printUserName(Players players) {
        System.out.println(userNamesFormatter.format(players));
    }

    public void printLadder(Ladder ladder) {
        System.out.println(ladderFormatter.format(ladder));
    }
}
