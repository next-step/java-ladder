package ladder;

import ladder.domain.Ladder;
import ladder.domain.RandomLinkStrategy;
import ladder.ui.InputView;
import ladder.ui.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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

        List<Integer> result = ladder.getResult();
        Map<String, String> prizeTable = IntStream.range(0, attendees.size())
                .collect(HashMap::new, (m, i) -> m.put(attendees.get(i), prizes.get(result.get(i))), HashMap::putAll);

        String who;
        while(!(who = InputView.whoseResult()).isEmpty()) {
            OutputView.showPrize(prizeTable, who);
        }
    }
}
