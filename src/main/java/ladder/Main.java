package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = User.of(InputView.inputUser());
        List<LadderPrize> ladderPrizes = LadderPrize.of(InputView.inputLadderResult());
        int height = InputView.inputHeight();

        Ladder ladder = new Ladder(LadderHeight.of(height), users.size());
        Participants participants = Participants.of(users, ladder);
        OutputView.printLadder(participants, ladder, ladderPrizes);

        LadderGame ladderGame = new LadderGame(participants, ladder);

        String name = InputView.inputUserNameToShowLadderResult();

        List<Integer> ladderPrizesIndex = ladderGame.play(name);
        OutputView.printLadderResult(ladderPrizesIndex, ladderPrizes, participants);

    }
}
