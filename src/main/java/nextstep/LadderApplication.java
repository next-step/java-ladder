package nextstep;

import java.util.List;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.RandomDraw;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        final List<String> participants = InputView.inputNameOfParticipant();
        final Height height = InputView.inputNumberOfHeight();
        final Ladder ladder = new Ladder(participants.size(), height);
        ladder.makeLadder(new RandomDraw());
        ResultView.printParticipant(participants);
        ResultView.print(ladder);
    }
}
