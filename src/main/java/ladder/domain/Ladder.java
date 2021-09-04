package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private int width;
    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int width, LineGenerateStrategy lineGenerateStrategy) {
        this.width = width;
        IntStream.range(0, height)
                .forEach(idx -> lines.add(new Line(width, lineGenerateStrategy)));
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public int resultOf(int currentIndex) {
        int endIndex = currentIndex;
        for (Line line : lines) {
            endIndex = line.move(endIndex);
        }
        return endIndex;
    }

    public List<Integer> resultAllIndexes() {
        List<Integer> resultAllIndexes = new ArrayList<>();
        IntStream.range(0, width)
                .forEach(index -> resultAllIndexes.add(resultOf(index)));
        return resultAllIndexes;
    }

    public Stream<Line> stream(){
        return lines.stream();
    }
}
