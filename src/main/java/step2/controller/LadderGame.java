package step2.controller;

import step2.domain.*;
import step2.service.LadderGameService;
import step2.strategy.LineCreateStrategy;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String COLON = " : ";
    private static final String NEW_LINE = "\n";
    private static final String NOT_FOUND_PARTICIPANT = "존재하지 않는 사용자 입니다.";
    private static final String ALL = "all";

    private final LineCreateStrategy lineCreateStrategy;
    private final LadderGameService ladderGameService;

    private LadderGame(LineCreateStrategy lineCreateStrategy) {
        this.lineCreateStrategy = lineCreateStrategy;
        this.ladderGameService = new LadderGameService();
    }

    public static LadderGame create(LineCreateStrategy lineCreateStrategy) {
        return new LadderGame(lineCreateStrategy);
    }

    public void start(GameInfo gameInfo, Height height) {
        Participants participants = gameInfo.participants();
        Rewards rewards = gameInfo.rewards();

        LadderInfo ladderInfo = LadderInfo.of(participants.size(), height.getHeight());
        Ladder ladder = Ladder.create(ladderInfo, lineCreateStrategy);
        ResultView.showResult(participants, ladder, rewards);

        GameHistory history = ladderGameService.start(ladder, ladderInfo);

        result(history, participants, rewards);
    }

    private void result(GameHistory history, Participants participants, Rewards rewards) {
        Map<String, String> savedHistory = history.save(participants, rewards);
        String rewardResultName = "";
        while (!selectAll(rewardResultName)) {
            rewardResultName = InputView.inputRewardResultName();
            showResult(savedHistory, rewardResultName);
        }
        showAllResult(savedHistory);
    }

    private void showResult(Map<String, String> savedHistory, String rewardResultName) {
        if (selectAll(rewardResultName)) {
            return;
        }
        ResultView.showRewardResult(participantReward(savedHistory, rewardResultName));
    }

    private void showAllResult(Map<String, String> savedHistory) {
        ResultView.showRewardAllResult(allReward(savedHistory));
    }

    private boolean selectAll(String resultName) {
        return ALL.equalsIgnoreCase(resultName);
    }

    private String participantReward(Map<String, String> savedHistory, String rewardResultName) {
        return savedHistory.getOrDefault(rewardResultName, NOT_FOUND_PARTICIPANT);
    }

    private String allReward(Map<String, String> savedHistory) {
        return savedHistory.keySet().stream()
                .map((key) -> key + COLON + savedHistory.get(key))
                .collect(Collectors.joining(NEW_LINE));
    }
}
