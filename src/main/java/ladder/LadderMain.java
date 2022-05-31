package ladder;

import java.util.List;
import ladder.domain.Ladder;
import ladder.ui.LadderScanner;
import ladder.ui.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        String input = LadderScanner.insertParticipant();
        List<String> participants = List.of(input.split(","));
        int height = LadderScanner.insertLadderHeight();

        Ladder ladder = new Ladder(participants.size() - 1, height);

        ResultView.printResult(participants, ladder);
    }
}
