package laddarGame.controller;

import laddarGame.domain.LadderGame;
import laddarGame.dto.LinesDto;
import laddarGame.dto.PlayersDto;
import laddarGame.view.InputView;
import laddarGame.view.OutputView;

public class GameController {

    private final LadderGame ladderGame;
    private final MatchOfPrize matchOfPrize;

    public GameController(String playerNames, int ladderHeight, String prizeList) {
        this.ladderGame = new LadderGame(playerNames, ladderHeight);
        this.matchOfPrize = new MatchOfPrize(prizeList);
    }

    public void outPutLadder() {
        LinesDto linesDto = ladderGame.ladderDto();
        PlayersDto playersDto = ladderGame.playersDto();
        OutputView.print(linesDto, playersDto);
    }

    public PlayersDto play() {
        return ladderGame.play();
    }

    public static void main(String[] args) {
        String playerNames = InputView.playerName();
        String prizeList = InputView.prize();
        int ladderHeight = InputView.ladderHeight();
        GameController gameController = new GameController(playerNames, ladderHeight, prizeList);
        gameController.outPutLadder();

        while (true) {
            String player = InputView.prizeOfPlayer();
            //gameController.matchOfPrize(player);
            OutputView.printMatchResult();
        }
    }
}

