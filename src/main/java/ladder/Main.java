package ladder;

import ladder.domain.*;
import ladder.domain.factory.LadderGameFactory;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        LadderGame ladderGame = LadderGameFactory.createLadderGame(LadderGameInfo.readInput());

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
