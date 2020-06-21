package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.play.Items;
import ladder.util.ConvertUtils;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        List<String> names = ConvertUtils.split(InputView.doInputParticipants());
        int height = InputView.doInputLadderHeight();

        Items players = Items.of(names);
        Ladder ladder = Ladder.of(height, players);
        ResultView.printResult(ladder);
    }
}
