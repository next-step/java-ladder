package step4.controller;

import step4.domain.GameInfo;
import step4.domain.GameResult;
import step4.domain.Ladder;
import step4.domain.LadderInfo;
import step4.strategy.RandomPointCreateStrategy;
import step4.view.InputView;
import step4.view.ResultView;

public class LadderGame {
    private static final String ALL = "all";

    private final GameInfo gameInfo;

    private LadderGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    public static LadderGame create(GameInfo gameInfo) {
        return new LadderGame(gameInfo);
    }

    public void start(LadderInfo ladderInfo) {
        Ladder ladder = Ladder.of(ladderInfo, new RandomPointCreateStrategy());
        ResultView.ladderResult(ladder, gameInfo);

        GameResult gameResult = GameResult.of(gameInfo, ladder);

        result(gameResult);
    }

    private void result(GameResult gameResult) {
        String name = "";
        while (!selectAll(name)) {
            name = InputView.inputParticipantResult();
            showResult(name, gameResult.result(name));
        }
        showAllResult(gameResult.resultAll());
    }

    private boolean selectAll(String name) {
        return ALL.equalsIgnoreCase(name);
    }

    private void showResult(String name, String reward) {
        if (selectAll(name)) {
            return;
        }
        ResultView.participantResult(reward);
    }

    private void showAllResult(String resultAll) {
        ResultView.allParticipantResult(resultAll);
    }
}
