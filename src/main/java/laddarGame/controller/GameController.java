package laddarGame.controller;

import laddarGame.domain.LadderGame;
import laddarGame.dto.LinesDto;
import laddarGame.dto.PlayersDto;
import laddarGame.view.InputView;
import laddarGame.view.OutputView;

public class GameController {

    private final LadderGame ladderGame;

    public GameController(String playerNames, int ladderHeight) {
        this.ladderGame = new LadderGame(playerNames, ladderHeight);
    }

    public void outPutLadder() {
        LinesDto linesDto = ladderGame.ladderDto();
        PlayersDto playersDto = ladderGame.playersDto();
        OutputView.print(linesDto, playersDto);
    }

    public static void main(String[] args) {
        String playerNames = InputView.playerName();
        int ladderHeight = InputView.ladderHeight();
        GameController gameController = new GameController(playerNames, ladderHeight);
        gameController.outPutLadder();
    }
}

