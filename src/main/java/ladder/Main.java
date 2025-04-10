package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Players players = new Players(inputView.getUsers());
        Height height = inputView.getHeight();
        Ladder ladder = new Ladder(height.getLength(), players.countOfPlayer());

        resultView.printResult(players, ladder);
    }
}
