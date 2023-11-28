package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String participators = inputView.inputParticipators();
        int ladderHeight = inputView.inputLadderHeight();




        outputView.printResult();
    }
}
