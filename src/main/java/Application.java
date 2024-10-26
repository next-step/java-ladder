import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final LadderGame ladderGame = new LadderGame(InputView.inputUserNames(), InputView.inputResults(),
                InputView.maxLength());

        printLadderGame(ladderGame);
        printLadderResult(ladderGame);
    }

    private static void printLadderGame(LadderGame ladderGame) {
        OutputView.printGeneratedLadder(ladderGame.getUsers(), ladderGame.getLadder(), ladderGame.getLadderPrizes());
    }

    private static void printLadderResult(LadderGame ladderGame) {
        String inputValue = "";
        while (!ladderGame.isEnd(inputValue)) {
            inputValue = InputView.inputUserWithPrize();
            printByInputType(inputValue, ladderGame);
        }
    }

    private static void printByInputType(String inputValue, LadderGame ladderGame) {
        if (ladderGame.isEnd(inputValue)) {
            printTotalResult(ladderGame);
            return;
        }
        OutputView.printPersonalResult(ladderGame.findUserToPrize(inputValue));
    }

    private static void printTotalResult(LadderGame ladderGame) {
        OutputView.printTotalPrize(ladderGame.getLadderResult());
    }
}
