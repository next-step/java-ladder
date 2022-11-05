package ladder;

import static ladder.view.InputView.inputLadderHeight;
import static ladder.view.InputView.inputParticipants;
import static ladder.view.OutputView.printResult;

import ladder.domain.Ladder;
import ladder.strategy.RandomLinkStrategy;

public class LadderApplication {

    public static void main(String[] args) {
        String participants = inputParticipants();
        int height = inputLadderHeight();

        Ladder ladder = new Ladder(participants, height);
        ladder.draw(new RandomLinkStrategy());

        printResult(ladder);
    }
}
