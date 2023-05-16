package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.Participants;
import nextstep.domain.Record;
import nextstep.view.InputView;
import nextstep.view.PrintView;

public class LadderGame {

    public static void main(String[] args) {
        String[] splitedParticipants = InputView.allParticipants();
        String[] gameResult = InputView.gameResult();
        int height = InputView.height();

        Participants participants = Participants.participate(splitedParticipants);
        Ladder ladder = Ladder.makeLadder(height, participants.count());
        Record record = participants.go(ladder, gameResult);

        PrintView.printResult(participants, ladder, gameResult);

        String participant = InputView.participant();
        PrintView.printFinalResult(participant, record);
    }
}
