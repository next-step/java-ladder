package ladder;

import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = InputView.scanNames();
        Integer height = InputView.scanHeight();

        ResultView.printIntro();
        ResultView.printNames(names);
        ResultView.printLadders(names.size(), height);
    }
}
