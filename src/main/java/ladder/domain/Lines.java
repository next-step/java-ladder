package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(int height, int width, RungGenerator generator) {
        validLadderLength(height);
        validLadderLength(width);
        this.lines = createLadder(height, width, generator);
    }

    private void validLadderLength(int value) {
        if (value < 1)
            throw new IllegalArgumentException("The ladder height should be larger than zero.");
    }

    private List<Line> createLadder(int height, int width, RungGenerator generator) {
        return IntStream.range(0, height)
                .mapToObj(i -> new Line(width, generator))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public boolean hasSameHeight(int height) {
        return lines.size() == height;
    }

    public boolean hasSameWidth(int width) {
        return lines.stream().allMatch(line -> line.hasSameWidth(width));
    }

    public List<Integer> run(int points) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < points; i++) {
            result.add(i);
            for (Line line : lines) {
                result.set(i, line.move(result.get(i)));
            }
        }
        return result;
    }
}
