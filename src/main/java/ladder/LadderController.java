package ladder;

import ladder.domain.Lines;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public void execute() {
        String person = InputView.inputName();
        int height = InputView.inputLadderHeight();
        Lines lines = new Lines(height, person);
        ResultView.print(lines);
    }
}
