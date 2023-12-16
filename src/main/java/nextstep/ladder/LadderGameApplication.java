package nextstep.ladder;

import nextstep.ladder.domain.JoinMembers;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.OutputView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        List<String> inputNames = InputView.inputNames();
        int inputHeight = InputView.inputHeight();

        LadderGame ladderGame = LadderGame.of(JoinMembers.from(inputNames), inputHeight);

        OutputView.outputLadderGame(ladderGame);
    }
}
