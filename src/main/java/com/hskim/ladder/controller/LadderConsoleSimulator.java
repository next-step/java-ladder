package com.hskim.ladder.controller;

import com.hskim.ladder.model.Ladder;
import com.hskim.ladder.model.LadderHeight;
import com.hskim.ladder.model.LadderUsers;
import com.hskim.ladder.model.Lines;
import com.hskim.ladder.model.RandomRowIndexMaker;
import com.hskim.ladder.model.Reward;
import com.hskim.ladder.model.Rewards;
import com.hskim.ladder.model.RowIndexMaker;
import com.hskim.ladder.model.User;
import com.hskim.ladder.ui.LadderInputView;
import com.hskim.ladder.ui.LadderResultView;

import java.util.Collections;
import java.util.Map;

public class LadderConsoleSimulator {
    private static final RowIndexMaker LADDER_MAKE_POLICY = new RandomRowIndexMaker();
    private static final String INVALID_RESULT_USER = "참여자에 포함되어 있지 않은 유저입니다.";
    private static final String ALL_USER_RESULT_INPUT = "all";

    private final LadderInputView ladderInputView;
    private final LadderResultView ladderResultView;
    private LadderUsers ladderUsers;
    private Ladder ladder;
    private Rewards rewards;

    public LadderConsoleSimulator(LadderInputView ladderInputView, LadderResultView ladderResultView) {
        this.ladderInputView = ladderInputView;
        this.ladderResultView = ladderResultView;
    }

    public void recruitParticipants() {
        ladderUsers = getLadderUsersFromInput();
    }

    private LadderUsers getLadderUsersFromInput() {
        ladderInputView.printParticipantsPhrase();
        return new LadderUsers(User.makeUsersFromNames(ladderInputView.getUserInputs()));
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

    public void setRewards() {
        rewards = getRewardsFromInput();
    }

    private Rewards getRewardsFromInput() {
        ladderInputView.printRewardPhrase();
        return new Rewards(Reward.makeRewardsFromNames(ladderInputView.getUserInputs()), ladderUsers);
    }

    public void printInitStatus() {
        ladderResultView.printLadderResultPhrase();
        ladderResultView.printUserNames(ladderUsers.getUserNames());
        ladderResultView.printLines(ladder.getAllPoints());
        ladderResultView.printRewards(rewards.getAllRewardNames());
    }

    public void simulate() {
        while (true) {
            String resultUserName = getResultUserName();
            ladderResultView.printSimulateResult(getResultMap(resultUserName));
        }
    }

    private String getResultUserName() {
        ladderInputView.printResultUserPhrase();
        String resultUserName = ladderInputView.getResultUserName();

        if(resultUserName.equals(ALL_USER_RESULT_INPUT)) {
            return resultUserName;
        }

        try {
            validateResultUser(resultUserName);
        } catch (Exception e) {
            System.out.println(INVALID_RESULT_USER);
        }

        return resultUserName;
    }

    private void validateResultUser(String resultUserName) {
        if (!ladderUsers.contains(new User(resultUserName))) {
            throw new IllegalArgumentException(INVALID_RESULT_USER);
        }
    }

    private Map<String, String> getResultMap(String resultUserName) {
        return Collections.emptyMap();
    }
}
