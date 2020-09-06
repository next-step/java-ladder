package ladder;

import ladder.model.LadderGame;
import ladder.model.LadderResult;
import ladder.model.Prizes;
import ladder.model.RandomGenerateStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderApplication {
    private static final String ALL_USER_QUERY_STRING = "all";

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> userNames = inputView.getUserNames();
        List<String> prizeNames = inputView.getPrizeNames();
        int width = inputView.getWidth();

        LadderGame ladderGame = LadderGame.of(userNames, width, new RandomGenerateStrategy());
        Prizes prizes = Prizes.of(prizeNames);

        resultView.printLadderResultPhrase();
        resultView.printLadderElements(ladderGame.getUsersName());
        resultView.printLadder(ladderGame.getLines());

        ladderGame.play();
        LadderResult ladderResult = ladderGame.makeLadderResult(prizes);

        resultView.printLadderElements(prizes.getPrizeNames());
        String resultUserName = inputView.getResultUserName();

        if (ALL_USER_QUERY_STRING.equals(resultUserName)) {
            resultView.printAllResults(userNames, ladderResult);
            return;
        }

        resultView.printResult(resultUserName, ladderResult);
    }

}
