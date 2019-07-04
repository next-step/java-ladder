package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {

        GameInfo gameInfo = GameInfo.of(new Participants(InputView.askParticipantNames()), new Goals(InputView.askGoals()));
        Ladder ladder = new Ladder(LadderInfo.of(gameInfo.getParticipants().size(), InputView.askHeight()));

        ResultView.printResultMessage();
        ResultView.printNewLine();
        ResultView.printParticipants(gameInfo.getParticipants());
        ResultView.printLadder(ladder);
        ResultView.printGoals(gameInfo.getGoals());

        LadderResult ladderResult = LadderResult.of(ladder);
        ParticipantGoals participantGoals = ladderResult.createParticipantGoal(gameInfo);

        String name = InputView.askPersonalResult();
        while (!Participants.ALL.equals(name)) {
            ResultView.printParticipantGoal(participantGoals.find(name));
            name = InputView.askPersonalResult();
        }
        ResultView.printAllParticipantGoal(participantGoals.findAll());
    }
}
