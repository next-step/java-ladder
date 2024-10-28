package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGenerator;
import nextstep.ladder.domain.Participants;

import static nextstep.ladder.view.InputView.inputLadderHeight;
import static nextstep.ladder.view.InputView.inputParticipantNames;
import static nextstep.ladder.view.ResultView.printResult;

public class LadderMain {
    public static void main(String[] args) {
        Participants participants = new Participants(inputParticipantNames());
        LadderGenerator generator = new LadderGenerator(participants.getParticipantCount(), inputLadderHeight());
        Ladder ladder = generator.generateLadder();
        printResult(ladder, participants.getParticipantNames());
    }
}
