package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {

        String participantsNames = InputView.askParticipantNames();
        Participants participants = new Participants(participantsNames);

        String goalsString = InputView.askGoals();
        Goals goals = new Goals(goalsString, participants.size());
        int height = InputView.askHeight();
        Ladder ladder = new Ladder(participants.size(), height);

        ResultView.printResultMessage();
        ResultView.printNewLine();
        ResultView.printParticipants(participants);
        ResultView.printLadder(ladder);
        ResultView.printGoals(goals);


    }
}
