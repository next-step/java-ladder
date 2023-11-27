package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    public static void main(String[] args) {
        String participantNames = InputView.participantNames();
        Participant participant = new Participant(participantNames);
        System.out.println();

        int ladderLevel = Parser.numberFormatParsing(InputView.ladderLevel());
        System.out.println();

        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < ladderLevel; i++) {
            ladder.add(new Line(participant.size()));
        }

        ResultView.printParticipantNames(participant.getParticipant());
        ResultView.printLadder(ladder);
    }
}
