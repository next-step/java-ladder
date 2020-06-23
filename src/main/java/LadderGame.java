import domain.Ladder;
import domain.Players;
import view.InputView;
import view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        Players players = InputView.inputPersonNames();

        String[] results = InputView.inputResults();

        Ladder ladder = new Ladder(players.countOfPlayers(), InputView.inputLadderHeight());

        OutputView.printResult(players, ladder, results);
    }
}
