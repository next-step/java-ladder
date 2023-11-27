package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApp {

    public static final String ALL = "all";

    public static void main(String[] args) {
        final Participants participants = new Participants(InputView.inputParticipants());
        final Results result = new Results(participants.countOfPerson(), InputView.inputResult());
        final Height ladderHeight = new Height(InputView.inputLadderHeight());

        ResultView.println(participants.toString());
        final Ladder ladder = new Ladder(participants.countOfPerson(), ladderHeight.get());
        ResultView.print(ladder.toString());
        ResultView.println(result.toString());

        final LadderResult ladderResult = ladder.start(participants, result);

        String resultInput = InputView.inputParticipantLadderResult();
        while (isNotAll(resultInput)) {
            final String participantResult = ladderResult.participantResult(new Participant(resultInput));
            ResultView.println(participantResult);
            resultInput = InputView.inputParticipantLadderResult();
        }
        ResultView.println(ladderResult.participantResult());
    }

    private static boolean isNotAll(String resultInput) {
        return !ALL.equals(resultInput);
    }
}
