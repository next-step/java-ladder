package ladder;

import ladder.domain.*;
import ladder.view.LadderInputView;
import ladder.view.LadderView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {
        LadderInputView ladderInputView = LadderInputView.enterLadderInput();

        GameAttendees gameAttendees = new GameAttendees(ladderInputView.getGameAttendees());
        LadderCompensation ladderCompensation = new LadderCompensation(ladderInputView.getLadderCompensation());

        Ladder ladder = new Ladder(gameAttendees, ladderInputView.getLadderHeight(), new RandomLineStrategy());

        LadderView.drawGameAttendees(gameAttendees);
        LadderView.drawLadder(ladder);
        LadderView.drawLadderCompensation(ladderCompensation);

        LadderResult ladderResult = ladder.playLadderGame(gameAttendees, ladderCompensation);
        while (true) {
            String attendees = ResultView.enterAttendees();
            ResultView.printLadderResult(ladderResult.getLadderResultBy(attendees));
        }
    }
}
