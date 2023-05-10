package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderHeight;
import nextstep.ladder.domain.ladder.Lines;
import nextstep.ladder.domain.user.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Participants participants = Participants.of(InputView.showUserNamesConsole());
        LadderHeight ladderHeight = LadderHeight.from(InputView.showLadderHeightConsole());

        Ladder ladder = new Ladder(Lines.create(ladderHeight.getHeight(), participants.count()));
        ResultView.drawResultMessage();
        ResultView.drawParticipants(participants);
        ResultView.drawLadder(ladder);
    }

}
