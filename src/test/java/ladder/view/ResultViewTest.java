package ladder.view;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    @Test
    @DisplayName("출력 테스트")
    void printResult() {

        Participants participants = new Participants("pobi,honux,crong,jk");
        LadderGame ladderGame = LadderGame.of(GameInfo.of(participants, new Goals("꽝,5000,꽝,3000")),
                                              new Ladder(LadderInfo.of(participants.size(), 5)));

        ResultView.printResultMessage();
        ResultView.printNewLine();
        ResultView.printParticipants(ladderGame.getGameInfo().getParticipants());
        ResultView.printLadder(ladderGame.getLadder());
        ResultView.printGoals(ladderGame.getGameInfo().getGoals());

        LadderResult ladderResult = LadderResult.of(ladderGame.getLadder());
        ParticipantGoals participantGoals = ladderResult.createParticipantGoal(ladderGame.getGameInfo());
        String name = "pobi";
        while (!Participants.ALL.equals(name)) {
            ResultView.printParticipantGoal(participantGoals.find(name));
            name = "all";
        }
        ResultView.printAllParticipantGoal(participantGoals.findAll());
    }
}