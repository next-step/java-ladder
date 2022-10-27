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
        List<String> names = InputView.getNames();
        int height = InputView.getHeight();

        Ladder ladder = new Ladder(names, height);
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> new RandomLine(names.size()))
                .collect(Collectors.toUnmodifiableList());
        ladder.addLines(lines);

        PrintView.printLadder(ladder);
    }

}
