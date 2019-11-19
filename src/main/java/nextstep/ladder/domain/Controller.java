package nextstep.ladder.domain;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.Map;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String names = inputView.inputUser();
        String endings = inputView.inputEndings();
        Spots spots = new Spots(names, endings);

        int ladderHeight = inputView.inputLadderHeight();

        Game game = new Game(spots, ladderHeight);
        resultView.printSummary();
        resultView.printSpots(names);
        resultView.printLadder((List<Line>) game.getLadder());
        resultView.printSpots(endings);

        Map<String, String> result = game.doGame();
        resultView.printResult(result, inputView.inputFindName());
    }

}
