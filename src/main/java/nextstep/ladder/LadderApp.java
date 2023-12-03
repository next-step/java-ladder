package nextstep.ladder;

import nextstep.ladder.domain.*;
import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.ResultView.print;
import static nextstep.ladder.view.ResultView.println;

public class LadderApp {
    public static final String ALL = "all";

    public static void main(String[] args) {
        final Participants participants = inputParticipants();
        final Results result = inputResult(participants.countOfPerson());
        final Height ladderHeight = inputLadderHeight();

        println(participants.toString());
        final Ladder ladder = new Ladder(participants.countOfPerson(), ladderHeight.get());
        print(ladder.toString());
        println(result.toString());

        final LadderResult ladderResult = ladder.start(participants, result);

        String resultInput = inputParticipantLadderResult();
        while (isNotAll(resultInput)) {
            final String participantResult = ladderResult.participantResult(new Participant(resultInput));
            println(participantResult);
            resultInput = inputParticipantLadderResult();
        }
        println(ladderResult.participantResult());
    }

    private static boolean isNotAll(String resultInput) {
        return !ALL.equals(resultInput);
    }
}
