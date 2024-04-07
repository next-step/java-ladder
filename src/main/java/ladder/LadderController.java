package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public static void main(String[] args) {
        Participants participants = InputView.askParticipants();
        GamePrize gamePrize = InputView.askGamePrize(participants.countOfPerson());
        int ladderHeight = InputView.askLadderHeight();

        Ladder ladder = Ladder.generateLadder(ladderHeight, participants.countOfPerson());

        ResultView.showParticipants(participants);
        ResultView.showLadder(ladder);
        ResultView.showGamePrize(gamePrize);

        String participantForResult = InputView.askParticipantForResult();
        GameResult gameResult = GameResult.of(ladder, participants, gamePrize);
        ResultView.showGameResult(gameResult, participantForResult);
    }
}
