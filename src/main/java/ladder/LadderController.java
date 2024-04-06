package ladder;

import ladder.domain.GamePrize;
import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public static void main(String[] args) {
        Participants participants = InputView.askParticipants();
        GamePrize gamePrize = InputView.askGamePrize(participants.countOfPerson());
        int ladderHeight = InputView.askLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, participants.countOfPerson());

        ResultView.showParticipants(participants);
        ResultView.showLadder(ladder);
        ResultView.showGamePrize(gamePrize);

        String participantForResult = InputView.askParticipantForResult();
    }
}
