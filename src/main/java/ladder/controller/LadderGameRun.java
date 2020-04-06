package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameRun {

    public static void main(String[] args) {
        Players players = InputView.inputPlayers();

        int ladderHeight = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(players, ladderHeight);

        ResultView.viewSettingLadder(players, ladderGame.getLadder());
    }
}
