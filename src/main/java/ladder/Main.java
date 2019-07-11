package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        LadderGame ladderGame = LadderGame.of(GameInfo.of(new Participants(InputView.askParticipantNames()), new Goals(InputView.askGoals())), InputView.askHeight());

        ResultView.printResultMessage();
        ResultView.printLadderGame(ladderGame);

        LadderResult ladderResult = ladderGame.createResult();
        ParticipantGoals participantGoals = ladderResult.createParticipantGoal(ladderGame.getGameInfo());

        String name = InputView.askPersonalResult();
        while (!Participants.ALL.equals(name)) {
            ResultView.printParticipantGoals(Collections.singletonList(participantGoals.find(name)));
            name = InputView.askPersonalResult();
        }
        ResultView.printParticipantGoals(participantGoals.findAll());
    }
}
