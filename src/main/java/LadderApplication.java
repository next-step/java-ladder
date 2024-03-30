import domain.Height;
import domain.Ladder;
import domain.Players;
import view.InputView;
import view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Players players = InputView.promptForPlayer();
        Height height = InputView.promptForHeight();
        Ladder ladder = Ladder.of(players, height);

        ResultView resultView = new ResultView();
        ladder.display(resultView);
    }
}
