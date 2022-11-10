package ladder;

import static ladder.view.InputView.inputParticipants;
import static ladder.view.InputView.inputParticipant;
import static ladder.view.InputView.inputPrizes;
import static ladder.view.InputView.inputLadderHeight;
import static ladder.view.OutputView.printGameResult;
import static ladder.view.OutputView.printLadderResult;

import java.util.Map;
import ladder.domain.Name;
import ladder.domain.Prize;
import ladder.domain.Ladder;
import ladder.strategy.RandomLinkStrategy;

public class LadderApplication {

    public static void main(String[] args) {
        String participants = inputParticipants();
        String prizes = inputPrizes();
        int height = inputLadderHeight();

        Ladder ladder = new Ladder(participants, height, prizes);
        ladder.draw(new RandomLinkStrategy());

        printLadderResult(ladder);

        Map<Name, Prize> result = ladder.play();

        String participant = inputParticipant();
        printGameResult(result, participant);

        String all = inputParticipant();
        printGameResult(result, all);
    }
}
