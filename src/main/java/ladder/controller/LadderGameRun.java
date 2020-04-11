package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.PlayResults;
import ladder.domain.Players;
import ladder.dto.GameInfo;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameRun {
    private static final String KEYWORD_ALL_VIEW = "all";

    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        PlayResults playResults = InputView.inputPlayResults();
        GameInfo gameInfo = new GameInfo(players, playResults);
        int ladderHeight = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(gameInfo, ladderHeight);
        ResultView.viewLadder(players, playResults, ladderGame.getLadder());
        LadderGameResult ladderGameResult = ladderGame.getLadderGameResult();

        while (true) {
            String playerName = InputView.inputPlayerNameForViewResult();
            if (playerName.equals(KEYWORD_ALL_VIEW)) {
                break;
            }
            ResultView.viewPlayerResult(ladderGameResult, playerName);
        }
        ResultView.viewAllPlayerResult(ladderGameResult);
    }
}
