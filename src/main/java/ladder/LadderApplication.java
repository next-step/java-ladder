package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.LadderView;

import java.util.Random;

public class LadderApplication {
    public static void main(String[] args) {
        Participants participants = InputView.inputParticipants();
        Rewards rewards = InputView.inputResults();
        int maxHeight = InputView.inputMaxLadderHeight();

        Ladder ladder = Ladder.of(maxHeight, participants, randomStrategy());
        LadderView.printLadder(participants, ladder, rewards);
        LadderGame ladderGame = new LadderGame(participants, rewards, ladder);
        Results results = ladderGame.play();

        while (true) {
            Target target = InputView.inputTarget();
            LadderView.printTargetResult(results, target);
            if (!target.isContinue()) {
                break;
            }
        }
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
