package nextstep.ladder;

import nextstep.ladder.domain.JoinMembers;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.MatchingResult;
import nextstep.ladder.domain.RandomLineCreator;
import nextstep.ladder.domain.Rewards;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        JoinMembers joinMembers = InputView.createJoinMembers();
        Rewards rewards = InputView.createRewards();

        Ladder ladder = LadderFactory.create(new RandomLineCreator(), joinMembers.countOfMembers(), InputView.inputHeight());
        OutputView.outputLadder(joinMembers, ladder, rewards);

        MatchingResult matchingResult = ladder.play();
        LadderResult result = matchingResult.map(joinMembers, rewards);

        OutputView.outputResult(result);
    }
}
