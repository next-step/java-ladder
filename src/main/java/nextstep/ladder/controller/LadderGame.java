package nextstep.ladder.controller;

import nextstep.ladder.*;
import nextstep.ladder.views.InputView;
import nextstep.ladder.views.ResultView;

public class LadderGame {
    private final static String ALL_RESULT = "all";

    public void run() {
        Players players = Players.from(InputView.playerNames());
        Ladder ladder = Ladder.of(players.size(), InputView.ladderHeight());
        Results results = Results.from(InputView.ladderResults());
        LadderResult ladderResult = LadderResult.of(ladder, results);
        GameResults gameResults = GameResults.of(ladderResult, players);

        ResultView.showPlayersNames(players);
        ResultView.showLadder(ladder);
        ResultView.showResultValues(results);

        showPlayerResults(gameResults);
    }

    public void showPlayerResults(GameResults gameResults) {
        String name = InputView.choicePlayer();
        while(!isAllResult(name)) {
            GameResult gameResult = gameResults.getPlayerResult(name);
            ResultView.showPlayerResult(gameResult);
            name = InputView.choicePlayer();
        }
        ResultView.showAllResults(gameResults);
    }

    private boolean isAllResult(String value) {
        return value.equals(ALL_RESULT);
    }
}
