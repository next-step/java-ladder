package ladder;

import java.util.List;

import ladder.model.Ladder;
import ladder.model.Participants;
import ladder.view.InputView;
import ladder.view.OutputView;

public final class LadderMain {
    public static void main(String[] args) {
        final List<String> participantNames = InputView.inputParticipants();
        final List<String> rewards = InputView.inputRewards();

        if (participantNames.size() != rewards.size()) {
            System.out.println("참여자와 보상 갯수가 맞지 않습니다.");
            return;
        }
        final Participants participants = new Participants(participantNames);

        final int ladderHeight = InputView.inputLadderHeight();
        final Ladder ladder = Ladder.generateRandom(ladderHeight, participantNames.size());

        OutputView.printResult(participants, ladder);
    }
}
