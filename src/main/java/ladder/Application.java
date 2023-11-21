package ladder;

import ladder.domain.*;
import ladder.domain.util.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Names names = InputView.inputNames();
        int height = InputView.inputHeight();

        List<Row> ladder = Ladder.makeLadder(names.names().size() - 1, height, new RandomBooleanGenerator());

        ResultView.printResult(names, ladder);
    }

}
