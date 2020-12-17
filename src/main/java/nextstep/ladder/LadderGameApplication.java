package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderGenerateRule;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {

        List<String> names = InputView.inputNames();
        int height = InputView.inputHeight();

        LadderGame ladderGame = LadderGame.start(names, height, new LadderGenerateRule());

        ResultView.printNames(ladderGame.getUserNames());
        ResultView.printLadder(ladderGame.getLines());
    }
}
