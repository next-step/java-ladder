package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static final String ALL_PARTICIPANTS = "all";

    public static void main(String[] args) {

        String participantsNames = InputView.askParticipantNames();
        Participants participants = new Participants(participantsNames);
        String goalsString = InputView.askGoals();
        Goals goals = new Goals(goalsString, participants.size());
        int height = InputView.askHeight();
        Ladder ladder = new Ladder(LadderInfo.of(participants.size(), height));

        ResultView.printResultMessage();
        ResultView.printNewLine();
        ResultView.printParticipants(participants);
        ResultView.printLadder(ladder);
        ResultView.printGoals(goals);

        LadderResult ladderResult = LadderResult.of(ladder);
        ParticipantGoals participantGoals = ladderResult.createParticipantGoal(participants, goals);
        String name = InputView.askPersonalResult();
        while (!name.equals(ALL_PARTICIPANTS)) {
            ResultView.printPersonalResult(participantGoals, name);
            name = InputView.askPersonalResult();
        }

        ResultView.printAllResult(participantGoals, participants);
    }
}
