package nextstep.ladder.domain;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.OutputView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        List<String> inputNames = InputView.inputNames();
        int inputHeight = InputView.inputHeight();

        LadderGame ladderGame = LadderGame.of(JoinMembers.from(inputNames), inputHeight);

        OutputView.outputLadder(ladderGame);
    }
}
