package ladder;

import ladder.domain.InputNameType;
import ladder.domain.Ladder;
import ladder.util.InputScanner;
import ladder.util.OutputPrinter;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        List<String> names = InputScanner.readNames();
        List<String> results = InputScanner.readMatchingResult();
        int height = InputScanner.readLadderHeight();
        Ladder ladder = new Ladder(height, names);
        OutputPrinter.printDisplay(names, ladder, results);

        while (true) {
            String name = InputScanner.readNameToShowResult();
            OutputPrinter.printMatchingResult(transformName(name, names), ladder, results);
        }
    }

    private static List<String> transformName(String inputName, List<String> names) {
        InputNameType inputNameType = InputNameType.of(inputName);
        if (inputNameType == InputNameType.ALL) {
            return names;
        }

        return List.of(inputName);
    }
}
