package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.line.Line;
import ladder.line.RandomLine;
import ladder.view.InputView;
import ladder.view.PrintView;

public class LadderController {

    public void start() {
        Ladder ladder = getLadder();
        PrintView.printLadder(ladder);
    }

    private Ladder getLadder() {
        Ladder ladder = null;

        while (ladder == null) {
            ladder = initLadder();
        }

        return ladder;
    }

    private Ladder initLadder() {
        try {
            List<String> names = InputView.getNames();
            int height = InputView.getHeight();
            return initLadder(names, height);
        } catch (Exception e) {
            clearAndPrintTryAgain(e);
            return null;
        }
    }

    private Ladder initLadder(List<String> names, int height) {
        Ladder ladder = new Ladder(names, height);
        addLadder(ladder, names.size(), height);
        return ladder;
    }

    private void addLadder(Ladder ladder, int countOfPerson, int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> new RandomLine(countOfPerson))
                .collect(Collectors.toUnmodifiableList());
        ladder.addLines(lines);
    }

    private void clearAndPrintTryAgain(Exception e) {
        PrintView.printError(e);
        PrintView.printTryAgain();
        InputView.clear();
    }

}
