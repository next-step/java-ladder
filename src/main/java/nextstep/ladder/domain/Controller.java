package nextstep.ladder.domain;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.Map;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String nameString = inputView.inputUser();
        String endingString = inputView.inputEndings();
        int ladderHeight = inputView.inputLadderHeight();

        Game game = new Game(nameString, endingString, ladderHeight);
        resultView.printSummary();
        resultView.printSpots(nameString);
        resultView.printLadder((List<Line>) game.getLadder());
        resultView.printSpots(endingString);

        Map<String, String> result = game.doGame();
        resultView.printResult(result, inputView.inputFindName());
    }


}
