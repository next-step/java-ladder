package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {

        Participants participants = new Participants(InputView.askParticipantNames());
        LadderGame ladderGame = LadderGame.of(GameInfo.of(participants, new Goals(InputView.askGoals())),
                                              new Ladder(LadderInfo.of(participants.size(), InputView.askHeight())));

        ResultView.printResultMessage();
        ResultView.printNewLine();
        ResultView.printParticipants(ladderGame.getGameInfo().getParticipants());
        ResultView.printLadder(ladderGame.getLadder());
        ResultView.printGoals(ladderGame.getGameInfo().getGoals());

        LadderResult ladderResult = LadderResult.of(ladderGame.getLadder());
        ParticipantGoals participantGoals = ladderResult.createParticipantGoal(ladderGame.getGameInfo());

        String name = InputView.askPersonalResult();
        while (!Participants.ALL.equals(name)) {
            ResultView.printParticipantGoal(participantGoals.find(name));
            name = InputView.askPersonalResult();
        }
        ResultView.printAllParticipantGoal(participantGoals.findAll());
    }
}
