package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {

        LadderGame ladderGame = LadderGame.of(GameInfo.of(new Participants(InputView.askParticipantNames()), new Goals(InputView.askGoals())), InputView.askHeight());

        ResultView.printResultMessage();
        ResultView.printNewLine();
        ResultView.printParticipants(ladderGame.getGameInfo().getParticipants());
        ResultView.printLines(ladderGame.getLines());
        ResultView.printGoals(ladderGame.getGameInfo().getGoals());

        LadderResult ladderResult = LadderResult.of(ladderGame);
        ParticipantGoals participantGoals = ladderResult.createParticipantGoal(ladderGame.getGameInfo());

        String name = InputView.askPersonalResult();
        while (!Participants.ALL.equals(name)) {
            ResultView.printParticipantGoal(participantGoals.find(name));
            name = InputView.askPersonalResult();
        }
        ResultView.printAllParticipantGoal(participantGoals.findAll());
    }
}
