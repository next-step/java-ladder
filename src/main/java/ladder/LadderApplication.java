package ladder;

import ladder.domain.Ladder;
import ladder.util.InputScanner;
import ladder.util.OutputPrinter;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        List<String> names = InputScanner.readNames();
        int height = InputScanner.readLadderHeight();
        Ladder ladder = new Ladder(height, names.size());
        OutputPrinter.printResult(names, ladder);
    }
}
