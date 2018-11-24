package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {

        Attendees attendees = InputView.inputAttendees();
        Gifts gifts = InputView.inputGifts();
        LadderOption ladderOption = InputView.inputLadderOption();

        Ladder ladder = Ladder.create(ladderOption, attendees);
        ladder.drawLine();

        ResultView resultView = ResultView.create(attendees, gifts, ladder);
        resultView.showLadder();

        Attendee attendee = InputView.inputAttendee();
        resultView.showResult(attendee);
    }
}
