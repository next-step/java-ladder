package ladder;

import ladder.domain.Lines;
import ladder.view.ResultView;

public class LadderController {
    public void execute(String person, int height) {
        Lines lines = new Lines(height, person);
        ResultView.print(lines);
    }
}