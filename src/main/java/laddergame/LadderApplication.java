package laddergame;

import laddergame.domain.game.GameResult;
import laddergame.domain.game.LadderGame;
import laddergame.domain.game.Prizes;
import laddergame.domain.game.dto.GameInfoDto;
import laddergame.domain.vo.Height;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RandomConnectGenerator;
import laddergame.domain.player.Players;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        GameInfoDto gameInfoDto = InputView.inputGameInfos();

        LadderGame ladderGame = new LadderGame(gameInfoDto, new RandomConnectGenerator());

        OutputView.printPlayers(gameInfoDto.getPlayers());
        OutputView.printLadder(ladderGame.getLadder());
        OutputView.printPrizes(gameInfoDto.getPrizes());

        GameResult gameResult = ladderGame.startGame(gameInfoDto.getPlayers(), gameInfoDto.getPrizes());

        while (true) {
            String findName = InputView.inputFindResultName();

            if (findName.equals("all")) {
                break;
            }

            OutputView.printResult(gameResult.findByName(findName));
        }

        OutputView.printAllResult(gameResult.findAll());
    }
}
