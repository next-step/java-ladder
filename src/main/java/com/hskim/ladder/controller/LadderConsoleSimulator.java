package com.hskim.ladder.controller;

import com.hskim.ladder.model.Ladder;
import com.hskim.ladder.model.LadderHeight;
import com.hskim.ladder.model.LadderUsers;
import com.hskim.ladder.model.Lines;
import com.hskim.ladder.model.RandomRowIndexMaker;
import com.hskim.ladder.model.RowIndexMaker;
import com.hskim.ladder.model.User;
import com.hskim.ladder.ui.LadderInputView;
import com.hskim.ladder.ui.LadderResultView;

public class LadderConsoleSimulator {
    private static final RowIndexMaker LADDER_MAKE_POLICY = new RandomRowIndexMaker();

    private final LadderInputView ladderInputView;
    private final LadderResultView ladderResultView;
    private LadderUsers ladderUsers;
    private Ladder ladder;

    public LadderConsoleSimulator(LadderInputView ladderInputView, LadderResultView ladderResultView) {
        this.ladderInputView = ladderInputView;
        this.ladderResultView = ladderResultView;
    }

    public void recruitParticipants() {
        ladderUsers = getLadderUsersFromInput();
    }

    private LadderUsers getLadderUsersFromInput() {
        ladderInputView.printParticipantsPhrase();
        return new LadderUsers(User.makeUserFromNames(ladderInputView.getUserNames()));
    }

    public void createLadder() {
        LadderHeight ladderHeight = getLadderHeightFromInput();
        Lines lines = Lines.of(ladderHeight.getLineNum(),
                ladderUsers.getUserNumber(), LADDER_MAKE_POLICY);

        ladder = new Ladder.LadderBuilder(lines)
                .setLadderHeight(ladderHeight)
                .setLadderUsers(ladderUsers)
                .build();
    }

    private LadderHeight getLadderHeightFromInput() {
        ladderInputView.printLadderHeightPhrase();
        return new LadderHeight(ladderInputView.getLadderHeight());
    }

    public void printInitStatus() {
        ladderResultView.printResultPhrase();
        ladderResultView.printUserNames(ladderUsers.getUserNames());
        ladderResultView.printLines(ladder.getAllPoints());
    }
}
