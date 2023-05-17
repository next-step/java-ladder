package ladder;

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
            List<String> participantNames = getParticipantNames(name, names);
            OutputPrinter.printMatchingResult(participantNames, ladder, results);
        }
    }

    private static List<String> getParticipantNames(String name, List<String> names) {
        if (name.equals("all"))
            return names;

        return List.of(name);
    }
}
