package ladder.view;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    @Test
    @DisplayName("출력 테스트")
    void printResult() {

        LadderGame ladderGame = LadderGame.of(GameInfo.of(new Participants("pobi,honux,crong,jk"), new Goals("꽝,5000,꽝,3000")), 5);

        ResultView.printResultMessage();
        ResultView.printNewLine();
        ResultView.printParticipants(ladderGame.getGameInfo().getParticipants());
        ResultView.printLines(ladderGame.getLines());
        ResultView.printGoals(ladderGame.getGameInfo().getGoals());

        LadderResult ladderResult = LadderResult.of(ladderGame);
        ParticipantGoals participantGoals = ladderResult.createParticipantGoal(ladderGame.getGameInfo());

        String name = "pobi";
        while (!Participants.ALL.equals(name)) {
            ResultView.printParticipantGoal(participantGoals.find(name));
            name = "all";
        }
        ResultView.printAllParticipantGoal(participantGoals.findAll());
    }
}