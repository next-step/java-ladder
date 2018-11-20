package ladder;

import ladder.domain.Attendees;
import ladder.domain.Ladder;
import ladder.domain.LadderOption;
import ladder.view.InputView;
import ladder.view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {

        Attendees attendees = InputView.inputAttendees();
        LadderOption ladderOption = InputView.inputLadderOption();

        Ladder ladder = Ladder.create(ladderOption, attendees);
        ladder.drawLine();

        ResultView.showLadder(attendees, ladder);
    }
}
