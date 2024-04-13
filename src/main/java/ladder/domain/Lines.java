package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {
    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int height, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line newLine = new Line(countOfPerson);
            lines.add(newLine);
        }
        this.lines = lines;
    }

    public boolean hasAtLeastOneBridge(int countOfPlayer) {
        return IntStream.range(0, countOfPlayer - 1)
                .allMatch(i -> this.lines.stream().anyMatch(line -> line.getPoint(i)));
    }

    public List<Line> getLines() {
        return lines;
    }
}
