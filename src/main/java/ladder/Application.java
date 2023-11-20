package ladder;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.Names;
import ladder.domain.Row;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Names names = InputView.inputNames();
        int height = InputView.inputHeight();

        List<Row> ladder = new Ladder().make(names.names().size() - 1, height);

        ResultView.printResult(names, ladder);
    }

}
