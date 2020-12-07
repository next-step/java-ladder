package ladder;

import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomGeneratorLadderMover;
import ladder.domain.participant.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {

        LadderGame ladderGame = new LadderGame(new RandomGeneratorLadderMover());

        Participants participants = ladderGame.participatePeople(InputView.participantPerson());
        Ladder ladder = ladderGame.makeLadder(participants.participantCount() - 1, InputView.inputLadderHeight());

        ResultView.executeLadder(participants, ladder);

    }
}
