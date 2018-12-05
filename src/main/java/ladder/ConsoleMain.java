package ladder;

import ladder.domain.*;
import ladder.strategy.Difficulty;
import ladder.view.InputView;
import ladder.view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {

//        Attendees attendees = InputView.inputAttendees();
        Attendees attendees = Attendees.create("pobi,honux,crong,jk");

//        Gifts gifts = InputView.inputGifts();
        Gifts gifts = Gifts.create("꽝,5000,꽝,3000");
//        LadderOption ladderOption = InputView.inputLadderOption();
        LadderOption ladderOption = LadderOption.create("하");

        Ladder ladder = Ladder.create(ladderOption, attendees);

        ResultView resultView = ResultView.create(attendees, gifts, ladder);
        resultView.showLadder();

        Attendee attendee = InputView.inputAttendee();
        resultView.showResult(attendee);
    }
}
