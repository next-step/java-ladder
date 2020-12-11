package ladder;

import ladder.domain.Ladder;
import ladder.domain.RandomLinkStrategy;
import ladder.ui.InputView;
import ladder.ui.OutputView;

import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        List<String> attendees = InputView.getAttendees();
        int height = InputView.getHeight();

        Ladder ladder = Ladder.of(attendees.size(), height, new RandomLinkStrategy());
        OutputView.showAttendees(attendees);
        OutputView.showLadder(ladder);
    }
}
