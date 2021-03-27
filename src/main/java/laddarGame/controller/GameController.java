package laddarGame.controller;

import laddarGame.domain.LadderGame;
import laddarGame.domain.MatchOfPrize;
import laddarGame.domain.PrizesDto;
import laddarGame.dto.LinesDto;
import laddarGame.dto.MatchOfPrizeDto;
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
        PrizesDto prizesDto = matchOfPrize.allPrize();
        OutputView.print(linesDto, playersDto, prizesDto);
    }

    public void play() {
        matchOfPrize.match(ladderGame.play());
    }

    public MatchOfPrizeDto match(String player) {
        if (player.equals("all")) {
            return matchOfPrize.all();
        }
        return matchOfPrize.getPrizeResult(player);
    }

    public static void main(String[] args) {
        GameController gameController = new GameController(InputView.playerName(), InputView.ladderHeight(), InputView.prize());
        gameController.outPutLadder();
        gameController.play();
        while (true) {
            String player = InputView.prizeOfPlayer();
            OutputView.printMatchPrize(gameController.match(player));
        }
    }

}

