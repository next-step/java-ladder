package ladder.view;

import ladder.domain.*;
import ladder.domain.factory.LinesFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class ResultViewTest {

    @Test
    @DisplayName("출력 테스트")
    void printResult() {

        LadderGame ladderGame = new LadderGame(GameInfo.of(new Participants("pobi,honux,crong,jk"), new Goals("꽝,5000,꽝,3000")), LinesFactory.createLines(4, 5));

        ResultView.printResultMessage();
        ResultView.printLadderGame(ladderGame);

        LadderResult ladderResult = ladderGame.createResult();
        ParticipantGoals participantGoals = ladderResult.createParticipantGoal(ladderGame.getGameInfo());

        String name = "pobi";
        while (!Participants.ALL.equals(name)) {
            ResultView.printParticipantGoals(Collections.singletonList(participantGoals.find(name)));
            name = "all";

            ResultView.printParticipantGoals(participantGoals.findAll());
        }
    }
}