package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(int height, int width, LineGenerator generator) {
        validLadderLength(height);
        validLadderLength(width);
        this.lines = createLadder(height, width, generator);
    }

    private void validLadderLength(int value) {
        if (value < 1)
            throw new IllegalArgumentException("The ladder height should be larger than zero.");
    }

    private List<Line> createLadder(int height, int width, LineGenerator generator) {
        return IntStream.range(0, height)
                .mapToObj(i -> new Line(width, generator))
                .collect(Collectors.toList());
    }

    public List<List<Boolean>> getList() {
        return lines.stream()
                .map(Line::getList)
                .collect(Collectors.toUnmodifiableList());
    }
}
