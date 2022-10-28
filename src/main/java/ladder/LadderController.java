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
        int height;
        List<String> names;
        Ladder ladder = null;

        while (ladder == null) {
            names = InputView.getNames();
            height = InputView.getHeight();

            try {
                ladder = initLadder(names, height);
            } catch (Exception e) {
                clearAndPrintTryAgain(e);
            }
        }

        return ladder;
    }

    private void clearAndPrintTryAgain(Exception e) {
        PrintView.printError(e);
        PrintView.printTryAgain();
        InputView.clear();
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

}
