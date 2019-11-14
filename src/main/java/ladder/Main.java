package ladder;

import ladder.domain.LadderGame;
import ladder.domain.Height;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {
        Participants participants = InputView.getParticipants();
        Height height = InputView.getHeight();

        LadderGame ladderGame = LadderGame.of(participants, height);
        ResultView.showLadder(ladderGame);
    }

}
