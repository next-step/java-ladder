package nextstep.ladder;

import nextstep.ladder.domain.JoinMembers;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.OutputView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        List<String> inputNames = InputView.inputNames();
        List<String> inputPrizes = InputView.inputPrizes();
        int inputHeight = InputView.inputHeight();

        Ladder ladder = new Ladder(JoinMembers.fromMemberNames(inputNames), inputHeight);
        LadderResult results = ladder.getResults(inputPrizes);

        OutputView.outputLadder(ladder);
        OutputView.outputPrizes(inputPrizes);
        while (true) {
            String inputResultMember = InputView.inputResultMember();
            if (inputResultMember.equals("all")) {
                OutputView.outputPrizeResults(results);
                return;
            }
            OutputView.outputPrizeResult(results.getResult(inputResultMember));
        }
    }
}
