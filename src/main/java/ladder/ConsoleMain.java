package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.domain.Winnings;
import ladder.view.InputView;
import ladder.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String userNames = inputView.printInputUserNames();
        String[] names = Utils.stringSplitWithDelimiter(userNames, ",");
        Players players = new Players(names);

        int height = inputView.printInputLadderHeight();
        int countOfPerson = players.size();

        String winningValues = inputView.printInputWinnings();
        Winnings winnings = new Winnings(winningValues, countOfPerson);

        Ladder ladder = new Ladder(countOfPerson, height);
        Results results = ladder.playLadder(players, winnings);

        ResultView resultView = new ResultView();
        resultView.printNames(players.playersNames());
        resultView.printLadder(ladder);
        resultView.printWinnings(winnings.winningsString());
        String wantResult = inputView.printInputWantResult();
        String result = results.getResult(wantResult);
        resultView.printResults(result);
    }
}
