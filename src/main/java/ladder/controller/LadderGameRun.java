package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.PlayResults;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameRun {

    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        PlayResults playResults = InputView.inputPlayResults();
        int ladderHeight = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(players, playResults, ladderHeight);
        ResultView.viewSettingLadder(players, playResults, ladderGame.getLadder());
    }
}
