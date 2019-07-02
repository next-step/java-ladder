package ladder.view;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    @Test
    @DisplayName("출력 테스트")
    void printResult() {

        Participants participants = new Participants("pobi,honux,crong,jk");
        Goals goals = new Goals("꽝,5000,꽝,3000", participants.size());
        Ladder ladder = new Ladder(LadderInfo.of(participants.size(), 5));

        ResultView.printResultMessage();
        ResultView.printNewLine();
        ResultView.printParticipants(participants);
        ResultView.printLadder(ladder);
        ResultView.printGoals(goals);

        LadderResult ladderResult = LadderResult.of(ladder);
        ParticipantGoals participantGoals = ladderResult.createParticipantGoal(participants, goals);
        String name = "pobi";
        while (!name.equals("all")) {
            ResultView.printPersonalResult(participantGoals, name);
            name = "all";
        }

        ResultView.printAllResult(participantGoals, participants);

    }
}