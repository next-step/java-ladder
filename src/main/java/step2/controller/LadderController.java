package step2.controller;

import step2.model.LadderGame;
import step2.model.Player;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        List<Player> players = InputView.inputPlayers();

        int lineHeight = InputView.inputLadderHeight();
        LadderGame ladderGame = new LadderGame(lineHeight, players.size());

        OutputView.viewLadder(ladderGame, players);
    }
}
