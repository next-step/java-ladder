package ladder;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Player> players = inputView.printInputUserNames();

        int height = inputView.printInputLadderHeight();
        int countOfPerson = players.size();

        Ladder ladder = new Ladder(countOfPerson, height);

        ResultView resultView = new ResultView();
        resultView.printNames(players);
        resultView.printLadder(ladder);
    }
}
