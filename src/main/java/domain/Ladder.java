package domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public void paint(Consumer<Line> consumer) {
        lines.forEach(consumer);
    }

    LadderGameResult getResult() {
        LadderGameResult results = new LadderGameResult(
            IntStream
                .range(0, lines.get(0).size())
                .boxed()
                .collect(Collectors.toList()));

        for (Line line : lines) {
            results = results.move(line);
        }

        return results;
    }
}
