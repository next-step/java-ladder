package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        String userNames = InputView.printInputUserNames();
        String[] names = Utils.stringSplitWithDelimiter(userNames, ",");
        Players players = new Players(names);

//        int height = InputView.printInputLadderHeight();
        int countOfPerson = players.size();

        String winningValues = InputView.printInputWinnings();
        Winnings winnings = new Winnings(winningValues, countOfPerson);

        String level = InputView.printInputLevel();
        Level ladderLevel = Level.findLevel(level);

        Ladder ladder = new Ladder(countOfPerson, ladderLevel);
        LadderGame ladderGame = new LadderGame(ladder);
        Results results = ladderGame.playLadder(players, winnings);

        ResultView.printNames(players.toString());
        ResultView.printLadder(ladder);
        ResultView.printWinnings(winnings.toString());
        String wantResult = InputView.printInputWantResult();
        String result = results.getResult(wantResult);
        ResultView.printResults(result);
    }
}
