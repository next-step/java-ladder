package nextstep.ladder;

import nextstep.ladder.domain.MaxHeightOfLadder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.RunResults;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        Members members = InputView.inputMemberNames();
        RunResults runResults = InputView.inputRunResults();
        MaxHeightOfLadder maxHeightOfLadder = InputView.inputMaxHeightOfLadder();

        OutputView.outputLadder(members, maxHeightOfLadder, runResults);
    }
}
