package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Participants participants = Participants.of(InputView.inputUser());
        LadderPrizes ladderPrizes = LadderPrizes.of(participants, InputView.inputLadderResult());
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(LadderHeight.of(height), participants);
        OutputView.printLadder(participants, ladder, ladderPrizes);

        LadderGame ladderGame = new LadderGame(participants, ladder);
        String name;
        do {
            name = InputView.inputUserNameToShowLadderResult();
            List<Position> ladderPrizesPosition = ladderGame.play(name);
            OutputView.printLadderResult(participants, LadderPrizes.convert(ladderPrizesPosition, ladderPrizes));
        } while (!ladderGame.isFinishGame(name));
    }
}
