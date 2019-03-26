package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    public Ladder(int height, int lineCount) {
        lines = new ArrayList<>();
        IntStream.range(0, lineCount)
                .forEach(count -> {
                    Line line = new Line(height);
                    line.createRow();
                    lines.add(line);
                });
    }

    public void checkLadder() {
        IntStream.range(0, lines.size() - 1)
                .forEach(count -> lines.get(count).checkLine(lines.get(count + 1)));
    }

    public List<Line> getLines() {
        return lines;
    }
}
