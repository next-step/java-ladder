import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final LadderGame ladderGame = new LadderGame(InputView.inputUserNames(), InputView.inputResults(),
                InputView.maxLength());
        printLadderGame(ladderGame);
    }

    private static void printLadderGame(LadderGame ladderGame) {
        OutputView.printGeneratedLadder(ladderGame.getUsers(), ladderGame.getLadder(), ladderGame.getLadderPrizes());
    }
}
