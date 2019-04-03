package ladder;

import java.util.Scanner;

public class ConsoleApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String playerNames = InputView.inputNames(scanner);
        Players players = new Players(playerNames);

        String resultNames = InputView.inputResults(scanner);
        EndPoints ladderResults = new EndPoints(resultNames);

        int height = InputView.inputHeight(scanner);

        LadderGame ladderGame = new LadderGame(new RandomLadderGenerator());
        ladderGame.init(players.getCount(), height);
        OutputView.printLadder(players, ladderGame, ladderResults);

        GameResults gameResults = ladderGame.play(players, ladderResults);

        String selectionResult = null;
        do {
            selectionResult = InputView.inputSelectedPlayer(scanner);
            OutputView.printResult(gameResults, selectionResult);

        } while (!OutputView.isEndAnswer(selectionResult));
    }
}
