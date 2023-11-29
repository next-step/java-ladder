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

        int ladderLevel = Parser.numberFormatParsing(InputView.ladderLevel());

        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < ladderLevel; i++) {
            ladder.add(new Line(participants.size()));
        }
        ResultView.resultMessage();
        ResultView.printParticipantNames(participants.getParticipant());
        ResultView.printLadder(ladder);
    }
}
