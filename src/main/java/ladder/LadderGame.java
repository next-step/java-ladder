package ladder;

import ladder.domain.Ladder;
import ladder.domain.PrizeTable;
import ladder.domain.RandomLinkStrategy;
import ladder.ui.InputView;
import ladder.ui.OutputView;

import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        List<String> attendees = InputView.getAttendees();
        List<String> prizes = InputView.getPrizes();
        if(attendees.size() != prizes.size()) {
            throw new IllegalArgumentException("count of attendees and prize not equals");
        }
        int height = InputView.getHeight();

        Ladder ladder = Ladder.of(attendees.size(), height, new RandomLinkStrategy());
        OutputView.showLadder(attendees, ladder, prizes);

        PrizeTable prizeTable = PrizeTable.of(attendees, prizes, ladder.getResult());
        String who;
        while(!(who = InputView.whoseResult()).isEmpty()) {
            OutputView.showPrize(prizeTable, who);
        }
    }
}
