package nextstep.ladder;

import nextstep.ladder.domain.JoinMembers;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.MatchingResult;
import nextstep.ladder.domain.Rewards;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.OutputView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        JoinMembers joinMembers = InputView.createJoinMembers();

        List<String> inputPrizes = InputView.inputPrizes();
        Rewards rewards = InputView.createRewards();
        int inputHeight = InputView.inputHeight();

        Ladder ladder = new Ladder(joinMembers.countOfMembers(), inputHeight);
        MatchingResult matchingResult = ladder.play();
        LadderResult results = matchingResult.map(joinMembers, rewards);

        OutputView.outputLadder(joinMembers, ladder);
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
