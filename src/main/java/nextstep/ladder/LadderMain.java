package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGenerator;
import nextstep.ladder.domain.LadderPrinter;
import nextstep.ladder.domain.Participants;

import static nextstep.ladder.view.InputView.inputLadderHeight;
import static nextstep.ladder.view.InputView.inputParticipantNames;
import static nextstep.ladder.view.ResultView.printResult;

public class LadderMain {
    public static void main(String[] args) {
        String participantNames = inputParticipantNames();
        Participants participants = new Participants(participantNames);

        int height = inputLadderHeight();
        Ladder ladder = LadderGenerator.generateLadder(participants.getParticipantCount(), height);

        LadderPrinter printer = new LadderPrinter(ladder);
        printResult(participants.getParticipantNames(), printer.printLadder());
    }
}
