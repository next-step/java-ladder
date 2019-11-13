package nextstep.ladder.domain;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String nameString = inputView.inputUser();
        int ladderHeight = inputView.inputLadderHeight();

        Game game = new Game(nameString, ladderHeight);

        resultView.printResultLadder(game.getUsers(), game.getLadder());
    }


}
