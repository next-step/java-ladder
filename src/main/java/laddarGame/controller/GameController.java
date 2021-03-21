package laddarGame.controller;

import laddarGame.domain.LadderGame;
import laddarGame.view.InputView;

public class GameController {

    private LadderGame ladderGame;

    public GameController(String playerNames, int ladderHeight) {
        this.ladderGame = new LadderGame(playerNames, ladderHeight);
    }

    public void outPutLadder() {
//        ladderGame.ladderDto();
        ladderGame.playersDto();
    }

    public static void main(String[] args) {
        String playerNames = InputView.playerName();
        int ladderHeight = InputView.ladderHeight();
        GameController gameController = new GameController(playerNames, ladderHeight);
    }
}

