package ladder;

import java.util.List;
import java.util.Map;

import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.Participant;
import ladder.model.Reward;
import ladder.view.InputView;
import ladder.view.OutputView;

public final class LadderMain {
    public static void main(String[] args) {
        final List<String> participantNames = InputView.inputParticipants();
        final List<String> rewardNames = InputView.inputRewards();

        final LadderGame ladderGame = new LadderGame(participantNames, rewardNames);

        final int ladderHeight = InputView.inputLadderHeight();
        final Ladder ladder = ladderGame.initGame(ladderHeight);
        final Map<Participant, Reward> result = ladderGame.run(ladder);

        OutputView.printLadderWithInformation(ladderGame.getParticipants(), ladderGame.getRewards(), ladder);

        boolean isPrintFinished = false;
        while (!isPrintFinished) {
            final String nameOfResult = InputView.inputChoiceResult();
            isPrintFinished = OutputView.printResult(result, nameOfResult);
        }
    }
}
