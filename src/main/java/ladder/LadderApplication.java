package ladder;

import ladder.model.LadderGame;
import ladder.model.RandomGenerateStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> userNames = inputView.getUserNames();
        int width = inputView.getWidth();

        LadderGame ladderGame = LadderGame.of(userNames, width, new RandomGenerateStrategy());

        resultView.printResultPhrase();
        resultView.printUserNames(ladderGame.getUsersName());
        resultView.printLadder(ladderGame.getLines());

    }

}
