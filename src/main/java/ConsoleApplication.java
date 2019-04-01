import domain.game.LadderGameBoard;
import domain.game.LaddersAndPrizes;
import domain.player.Players;
import domain.prize.Prizes;
import view.InputView;
import view.ResultView;

import java.io.IOException;

public class ConsoleApplication {

    public static void main(String[] args) throws IOException {
        Players players = Players.generate(InputView.inputPlayerNames());
        Prizes prizes = Prizes.generate(InputView.inputRunResults());
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(InputView.inputHeight(), prizes);
        LadderGameBoard gameBoard = new LadderGameBoard(players, laddersAndPrizes);

        ResultView.viewLadders(players, laddersAndPrizes);
        String wantSeeResult;
        do {
            wantSeeResult = InputView.inputWantSeeResult();
            ResultView.viewResults(players, gameBoard.raffle(wantSeeResult));
        } while (!wantSeeResult.equals(LadderGameBoard.ALL_PLAYER_NAME));

    }
}
