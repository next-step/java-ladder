package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderGame {

    public static void run() {
        List<String> participantsName = getParticipants();
        int height = getLadderHeight();

        List<Line> ladder = Ladder.of(participantsName, height);

        OutputView.printLadder(participantsName,ladder);
    }

    private static int getLadderHeight() {
        OutputView.printAskLadderHeightMessage();
        return InputView.getLadderHeight();
    }

    private static List<String> getParticipants() {
        OutputView.printParticipantsMessage();
        return InputView.getParticipantsName();
    }
}
