package ladder;

import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomLineGenerator;
import ladder.domain.participant.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {

        LadderGame ladderGame = new LadderGame(new RandomLineGenerator());

        Participants participants = Participants.of(InputView.participantPerson());
        Ladder ladder = ladderGame.makeLadder(participants.countParticipant() - 1, InputView.inputLadderHeight());

        ResultView.outputLadder(participants, ladder);

    }
}
