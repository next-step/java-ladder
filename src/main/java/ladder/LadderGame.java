package ladder;

import ladder.domain.ladder.Ladder;
import ladder.util.ConvertUtils;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        List<String> names = ConvertUtils.split(InputView.doInputParticipants());
        int height = InputView.doInputLadderHeight();

        Ladder ladder = Ladder.of(height, names);
        ResultView.printResult(ladder);
    }
}
