package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderGenerateRule;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        List<String> names = inputView.inputNames();
        int height = inputView.inputHeight();

        LadderGame ladderGame = LadderGame.of(names, height, new LadderGenerateRule());

        resultView.printNames(ladderGame.getUserNames());
        resultView.printLadder(ladderGame.getLines());
    }
}
