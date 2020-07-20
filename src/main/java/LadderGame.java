import domain.Ladder;
import domain.LadderResult;
import domain.MatchingResult;
import domain.Players;
import view.InputView;
import view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        Players players = InputView.inputPersonNames();
        String[] results = InputView.inputResults();

        Ladder ladder = new Ladder(players.countOfPlayers(), InputView.inputLadderLevel());
        OutputView.printResult(players, ladder, results);

        MatchingResult matchingResult = ladder.play();
        LadderResult ladderResult = matchingResult.map(players, results);

        String who = InputView.inputWho();
        OutputView.printWhoResult(who, ladderResult);
    }
}
