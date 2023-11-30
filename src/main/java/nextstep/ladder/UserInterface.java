package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class UserInterface {
    public static void main(String[] args) {
        List<String> names = Parser.splitString(InputView.participantNames());
        Participants participants = new Participants(names);

        List<String> results = Parser.splitString(InputView.expectedResult());
        Results ladderResult = Results.of(participants, results);

        int ladderLevel = Parser.numberFormatParsing(InputView.ladderLevel());

        LadderFactory ladder = LadderFactory.make(participants, ladderLevel);

        ResultView.resultMessage();
        ResultView.printParticipantNames(participants.getParticipant());
        ResultView.printLadder(ladder.getLadder());
        ResultView.printResult(ladderResult.getResults());
    }
}
