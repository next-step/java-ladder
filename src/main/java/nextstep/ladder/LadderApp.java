package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApp {
    public static void main(String[] args) {
        final Participants participants = new Participants(InputView.inputParticipants());
        final Result result = new Result(participants.countOfPerson(), InputView.inputResult());
        final Height ladderHeight = new Height(InputView.inputLadderHeight());

        ResultView.println(participants.toString());
        final Ladder ladder = new Ladder(participants.countOfPerson(), ladderHeight.get());
        ResultView.print(ladder.toString());
        ResultView.println(result.toString());

        final LadderResult ladderResult = ladder.start(participants, result);
        System.out.println(ladderResult);
        InputView.inputParticipantLadderResult();

    }
}
