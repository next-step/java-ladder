package ladder;

import java.util.List;

import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.Result;
import ladder.view.InputView;
import ladder.view.OutputView;

public final class LadderMain {
    public static void main(String[] args) {
        final List<String> participantNames = InputView.inputParticipants();
        final List<String> rewardNames = InputView.inputRewards();

        final LadderGame ladderGame = new LadderGame(participantNames, rewardNames);

        final int ladderHeight = InputView.inputLadderHeight();
        final Ladder ladder = ladderGame.initGame(ladderHeight);
        final Result result = ladderGame.run(ladder);

        OutputView.printLadderWithInformation(ladderGame.getParticipants(), ladderGame.getRewards(), ladder);

        boolean isPrintFinished = false;
        while (!isPrintFinished) {
            final String nameOfResult = InputView.inputChoiceResult();
            isPrintFinished = OutputView.printResult(result, nameOfResult);
        }
    }
}
