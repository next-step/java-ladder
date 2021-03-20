package laddarGame.controller;

import laddarGame.domain.LadderGame;
import laddarGame.view.InputView;

public class GameController {

    private LadderGame ladderGame;

    public GameController(String playerNames, int ladderHeight) {
        this.ladderGame = new LadderGame(playerNames, ladderHeight);
    }

    public static void main(String[] args) {
        String playerNames = InputView.playerName();
        int ladderHeight = InputView.ladderHeight();
        GameController gameController = new GameController(playerNames, ladderHeight);
    }
}

