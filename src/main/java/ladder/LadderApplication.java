package ladder;

import ladder.domain.Ladder;
import ladder.domain.LineDrawStrategy;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.LadderView;

import java.util.Random;

public class LadderApplication {
    public static void main(String[] args) {
        Participants participants = InputView.inputParticipants();
        int maxHeight = InputView.inputMaxLadderHeight();

        Ladder ladder = Ladder.of(maxHeight, participants, randomStrategy());
        LadderView.printLadder(participants, ladder);
    }

    private static LineDrawStrategy randomStrategy() {
        return prev -> {
            if (prev) {
                return false;
            }
            return new Random().nextBoolean();
        };
    }
}
