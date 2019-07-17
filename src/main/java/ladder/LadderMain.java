package ladder;

import ladder.io.InputView;
import ladder.io.OutputView;

public class LadderMain {
    public static final String RESULT_ALL = "all";

    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        Players players = new Players(inputNames);
        int height = InputView.inputLadderHeight();
        Ladder ladder = Ladder.of(height, players.getSize());
        Prizes prizes = Prizes.of(InputView.inputPrizes());
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        OutputView.printNames(players);
        OutputView.printLadder(ladder);
        OutputView.printPrizes(prizes);

        String resultPlayer = InputView.inputStartGame();
        if (resultPlayer.equals(RESULT_ALL)) {
            OutputView.printResult(ladderGame.startGame());
            return;
        }
        OutputView.printResult(ladderGame.startGame(resultPlayer));
    }
}
