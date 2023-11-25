package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApp {
    public static void main(String[] args) {
        final Participants participants = new Participants(InputView.inputParticipants());
        final Result result = new Result(participants.countOfPerson(), InputView.inputLadderResult());
        final Height ladderHeight = new Height(InputView.inputLadderHeight());

        ResultView.println(participants.toString());
        final Ladder ladder = new Ladder(participants.countOfPerson(), ladderHeight.get());
        ResultView.print(ladder.toString());
        ResultView.print(result.toString());

    }
}
