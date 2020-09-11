package step04.controller;

import step04.model.Ladder;
import step04.model.LadderGameResult;
import step04.model.LadderHeight;
import step04.model.LadderMakeStrategy;
import step04.model.LadderUser;
import step04.model.LadderUsers;
import step04.model.RandomLadderMakeStrategy;
import step04.model.Reward;
import step04.model.Rewards;
import step04.model.RouteInfo;

import static step04.ui.LadderInputView.*;
import static step04.ui.LadderResultView.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderConsoleSimulator {
    private static final LadderMakeStrategy LADDER_MAKE_POLICY = new RandomLadderMakeStrategy();
    private static final String ALL_USER_RESULT_INPUT = "all";

    private LadderUsers ladderUsers;
    private Ladder ladder;
    private Rewards rewards;
    private LadderGameResult ladderGameResult;

    public void recruitParticipants() {
        this.ladderUsers = getLadderUsersFromInput();
    }

    private LadderUsers getLadderUsersFromInput() {
        printParticipantsPhrase();
        return new LadderUsers(LadderUser.makeUsersFromNames(getUserInputs()));
    }

    public void createLadder() {
        this.ladder = Ladder.withLines(new Ladder(getLadderHeightFromInput())
                , ladderUsers.getUserNumber(), LADDER_MAKE_POLICY);
    }

    private LadderHeight getLadderHeightFromInput() {
        printLadderHeightPhrase();
        return new LadderHeight(getLadderHeight());
    }

    public void setRewards() {
        rewards = getRewardsFromInput();
    }

    private Rewards getRewardsFromInput() {
        printRewardPhrase();
        return new Rewards(Reward.makeRewardsFromNames(getUserInputs()), ladderUsers);
    }

    public void printInitStatus() {
        printLadderResultPhrase();
        printUserNames(ladderUsers.printableUserStatus());
        printLadderLines(ladder.printableLadderStatus());
        printRewards(rewards.printableRewardsStatus());
    }

    public void simulate() {
        RouteInfo<Integer> navigateResult = ladder.getNavigateResult();

        Map<LadderUser, Reward> userRewardMap = navigateResult.getRouteMap()
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
            String resultUserName = getResultString();
            boolean isAll = resultUserName.equals(ALL_USER_RESULT_INPUT);
            printSimulateResult(ladderGameResult.getResultMap(resultUserName, isAll));

            if (isAll) {
                return;
            }
        }
    }

    private String getResultString() {
        printResultUserPhrase();
        String resultUserName = getResultUserName();

        if (resultUserName.equals(ALL_USER_RESULT_INPUT)) {
            return resultUserName;
        }

        try {
            ladderUsers.validateResultUser(resultUserName);
            return resultUserName;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
