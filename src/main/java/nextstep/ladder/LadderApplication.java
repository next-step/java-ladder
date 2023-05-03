package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Participants participants = Participants.of(InputView.showUserNamesConsole());
        LadderHeight ladderHeight = LadderHeight.from(InputView.showLadderHeightConsole());

        Ladder ladder = Ladder.create(ladderHeight, participants);
        ResultView.drawResultMessage();
        ResultView.drawParticipants(participants);
        ResultView.drawLadder(ladder);
    }

}
