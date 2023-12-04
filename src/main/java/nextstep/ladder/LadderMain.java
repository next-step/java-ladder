package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Random;

public class LadderMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Random random = new Random();

        Ladder ladder = Ladder.of(inputView.inputPlayer(), inputView.inputLadderHeight());
        ResultView.printLadder(ladder);
    }

}
