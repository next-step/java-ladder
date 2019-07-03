package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {

        Participants participants = new Participants(InputView.askParticipantNames());
        Goals goals = new Goals(InputView.askGoals(), participants.size());
        Ladder ladder = new Ladder(LadderInfo.of(participants.size(), InputView.askHeight()));

        ResultView.printResultMessage();
        ResultView.printNewLine();
        ResultView.printParticipants(participants);
        ResultView.printLadder(ladder);
        ResultView.printGoals(goals);

        LadderResult ladderResult = LadderResult.of(ladder);
        ParticipantGoals participantGoals = ladderResult.createParticipantGoal(participants, goals);
        String name = InputView.askPersonalResult();
        while (Participants.ALL.equals(name)) {
            ResultView.printPersonalResult(participantGoals, name);
            name = InputView.askPersonalResult();
        }

        ResultView.printAllResult(participantGoals, participants);
    }
}
