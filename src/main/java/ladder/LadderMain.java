package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.stream.Collectors;

public class LadderMain {

    private static final String LADDER_RESULT_CONFIRM_COMMAND_ALL = "all";
    private static final String LADDER_RESULT_CONFIRM_COMMAND_BREAK = "-1";

    public static void main(String[] args) {
        final Participants participants = new Participants(InputView.inputParticipantNames()
                                                                    .stream()
                                                                    .map(Participant::new)
                                                                    .collect(Collectors.toList()));
        final LadderResults ladderResults = new LadderResults(InputView.inputLadderResults()
                                                                       .stream()
                                                                       .map(LadderResult::new)
                                                                       .collect(Collectors.toList()));
        final LadderHeight ladderHeight = new LadderHeight(InputView.inputLadderHeight());
        final Ladder ladder = LadderFactory.create(participants, ladderHeight);
        ResultView.printLadder(ladder, ladderResults);

        while (true) {
            final String targetParticipantName = InputView.inputTargetLadderParticipantName();
            if (LADDER_RESULT_CONFIRM_COMMAND_ALL.equalsIgnoreCase(targetParticipantName)) {
                ResultView.printAllLadderResults(ladder, ladderResults);
                continue;
            }

            if (LADDER_RESULT_CONFIRM_COMMAND_BREAK.equalsIgnoreCase(targetParticipantName)) {
                ResultView.printConfirmationEndMessage();
                break;
            }

            ResultView.printLadderResult(ladder, ladderResults, new Participant(targetParticipantName));
        }
    }
}
