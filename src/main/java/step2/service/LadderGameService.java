package step2.service;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameService {
    public static final int START_POSITION = 0;
    public static final String COLON = " : ";
    public static final String NEW_LINE = "\n";
    public static final String NOT_FOUND_PARTICIPANT = "존재하지 않는 사용자 입니다.";

    public GameHistory start(Ladder ladder, LadderInfo ladderInfo) {
        GameHistory gameHistory = GameHistory.of();
        for (int currentPosition = START_POSITION; currentPosition < ladderInfo.getWidth(); currentPosition++) {
            Position position = Position.of(currentPosition);
            ladder.run(position);
            gameHistory.record(currentPosition, position.position());
        }
        return gameHistory;
    }

    public void result(GameHistory history, Participants participants, Rewards rewards) {
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
        return "all".equalsIgnoreCase(resultName);
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
