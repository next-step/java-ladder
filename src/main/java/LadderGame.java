import domain.Ladder;
import view.InputView;
import view.OutputView;

import java.util.*;

public class LadderGame {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<String> Names = InputView.getInputNames();
        Ladder ladder = new Ladder(Names.size(), inputView.getLadderCount());

        OutputView.printNames(Names);
        OutputView.printLine(ladder);
    }

}
