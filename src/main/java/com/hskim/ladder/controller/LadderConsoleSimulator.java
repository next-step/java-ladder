package com.hskim.ladder.controller;

import com.hskim.ladder.model.Ladder;
import com.hskim.ladder.model.LadderGameResult;
import com.hskim.ladder.model.LadderHeight;
import com.hskim.ladder.model.LadderUsers;
import com.hskim.ladder.model.Lines;
import com.hskim.ladder.model.RandomRowIndexMaker;
import com.hskim.ladder.model.Reward;
import com.hskim.ladder.model.Rewards;
import com.hskim.ladder.model.RouteInfo;
import com.hskim.ladder.model.RowIndexMaker;
import com.hskim.ladder.model.User;
import com.hskim.ladder.ui.LadderInputView;
import com.hskim.ladder.ui.LadderResultView;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderConsoleSimulator {
    private static final RowIndexMaker LADDER_MAKE_POLICY = new RandomRowIndexMaker();
    private static final String ALL_USER_RESULT_INPUT = "all";

    private final LadderInputView ladderInputView;
    private final LadderResultView ladderResultView;
    private LadderUsers ladderUsers;
    private Ladder ladder;
    private Rewards rewards;
    private LadderGameResult ladderGameResult;

    public LadderConsoleSimulator(LadderInputView ladderInputView, LadderResultView ladderResultView) {
        this.ladderInputView = ladderInputView;
        this.ladderResultView = ladderResultView;
    }

    public void recruitParticipants() {
        this.ladderUsers = getLadderUsersFromInput();
    }

    private LadderUsers getLadderUsersFromInput() {
        ladderInputView.printParticipantsPhrase();
        return new LadderUsers(User.makeUsersFromNames(ladderInputView.getUserInputs()));
    }

    public void createLadder() {
        LadderHeight ladderHeight = getLadderHeightFromInput();
        Lines lines = Lines.of(ladderHeight.getLineNum(),
                ladderUsers.getUserNumber(), LADDER_MAKE_POLICY);

        this.ladder = new Ladder.LadderBuilder(lines)
                .setLadderHeight(ladderHeight)
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
        ladderResultView.printUserNames(ladderUsers.printableUserStatus());
        ladderResultView.printLines(ladder.getAllPoints());
        ladderResultView.printRewards(rewards.printableRewardsStatus());
    }

    public void simulate() {
        RouteInfo<Integer> navigateResult = ladder.getNavigateResult();

        Map<User, Reward> userRewardMap = navigateResult.getRouteMap()
                .keySet()
                .stream()
                .collect(LinkedHashMap::new,
                        (map, key) -> map.put(ladderUsers.getUserByIndex(key),
                                rewards.getRewardByIndex(navigateResult.getValue(key))),
                        Map::putAll);

        ladderGameResult = new LadderGameResult(userRewardMap);
    }

    public void checkResult() {
        while (true) {
            String resultUserName = getResultUserName();
            boolean isAll = resultUserName.equals(ALL_USER_RESULT_INPUT);
            ladderResultView.printSimulateResult(ladderGameResult.getResultMap(resultUserName, isAll));
        }
    }

    private String getResultUserName() {
        ladderInputView.printResultUserPhrase();
        String resultUserName = ladderInputView.getResultUserName();

        if (resultUserName.equals(ALL_USER_RESULT_INPUT)) {
            return resultUserName;
        }

        try {
            ladderUsers.validateResultUser(resultUserName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return resultUserName;
    }
}
