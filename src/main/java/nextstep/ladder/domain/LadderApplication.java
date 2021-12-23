package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.strategy.RandomStrategy;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.domain.view.InputView;
import nextstep.ladder.domain.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        Participants participants = InputView.participants();
        int heightOfLadder = InputView.heightOfLadder();

        Condition condition = Condition.of(participants, heightOfLadder);
        Ladder ladder = Ladder.from(condition, new RandomStrategy());

        ResultView.result(participants, ladder);
    }
}
