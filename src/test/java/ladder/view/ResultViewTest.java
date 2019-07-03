package ladder.view;

import ladder.GameInfo;
import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    @Test
    @DisplayName("출력 테스트")
    void printResult() {

        GameInfo gameInfo = GameInfo.of(new Participants("pobi,honux,crong,jk"), new Goals("꽝,5000,꽝,3000"));
        Ladder ladder = new Ladder(LadderInfo.of(gameInfo.getParticipants().size(), 5));

        ResultView.printResultMessage();
        ResultView.printNewLine();
        ResultView.printParticipants(gameInfo.getParticipants());
        ResultView.printLadder(ladder);
        ResultView.printGoals(gameInfo.getGoals());

        LadderResult ladderResult = LadderResult.of(ladder);
        ParticipantGoals participantGoals = ladderResult.createParticipantGoal(gameInfo);
        String name = "pobi";
        while (!Participants.ALL.equals(name)) {
            ResultView.printPersonalResult(name, participantGoals.findGoal(name));
            name = "all";
        }

        ResultView.printAllResult(participantGoals, gameInfo.getParticipants());

    }
}