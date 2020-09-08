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
import step04.ui.LadderInputView;
import step04.ui.LadderResultView;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderConsoleSimulator {
    private static final LadderMakeStrategy LADDER_MAKE_POLICY = new RandomLadderMakeStrategy();
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
        return new LadderUsers(LadderUser.makeUsersFromNames(ladderInputView.getUserInputs()));
    }

    public void createLadder() {
        this.ladder = new Ladder(getLadderHeightFromInput());
        ladder.setLadderLines(ladderUsers.getUserNumber(), LADDER_MAKE_POLICY);
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
        ladderResultView.printLadderLines(ladder.printableLadderStatus());
        ladderResultView.printRewards(rewards.printableRewardsStatus());
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
            String resultUserName = getResultUserName();
            boolean isAll = resultUserName.equals(ALL_USER_RESULT_INPUT);
            ladderResultView.printSimulateResult(ladderGameResult.getResultMap(resultUserName, isAll));

            if (isAll) {
                return;
            }
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
