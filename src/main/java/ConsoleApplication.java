import domain.game.LadderGameBoard;
import domain.game.LaddersAndPrizes;
import domain.ladder.Ladders;
import domain.player.Players;
import domain.prize.Prizes;
import generator.bool.impl.ProbabilityBasedGenerator;
import generator.ladder.LaddersGenerator;
import generator.ladder.impl.RandomLineLaddersGenerator;
import view.InputView;
import view.ResultView;

import java.io.IOException;

public class ConsoleApplication {

    public static void main(String[] args) throws IOException {
        final LaddersGenerator laddersGenerator = new RandomLineLaddersGenerator(new ProbabilityBasedGenerator(50));

        final Players players = Players.generate(InputView.inputPlayerNames());
        final Prizes prizes = Prizes.generate(InputView.inputRunResults());
        final Ladders ladders = laddersGenerator.generate(InputView.inputHeight(), prizes.size());

        final LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(ladders, prizes);
        final LadderGameBoard gameBoard = new LadderGameBoard(players, laddersAndPrizes);

        ResultView.viewLadders(players, laddersAndPrizes);

        String wantSeeResult;
        do {
            wantSeeResult = InputView.inputWantSeeResult();
            ResultView.viewResults(players, gameBoard.raffle(wantSeeResult));
        } while (!wantSeeResult.equals(LadderGameBoard.ALL_PLAYER_NAME));

    }
}
