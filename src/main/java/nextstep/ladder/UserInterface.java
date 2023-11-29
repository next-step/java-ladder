package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    public static void main(String[] args) {
        String participantNames = InputView.participantNames();
        Participants participants = new Participants(participantNames);
        System.out.println();

        int ladderLevel = Parser.numberFormatParsing(InputView.ladderLevel());
        System.out.println();

        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < ladderLevel; i++) {
            ladder.add(new Line(participants.size()));
        }

        ResultView.printParticipantNames(participants.getParticipant());
        ResultView.printLadder(ladder);
    }
}
