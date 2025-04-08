package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int width, List<Line> lines) {
        validate(height, width, lines);
        this.lines = lines;
    }

    private void validate(int height, int width, List<Line> lines) {
        if (height < 1) {
            throw new RuntimeException("사다리의 높이는 1보다 작을 수 없습니다. 현재 값: " + height);
        }
        if (width < 2) {
            throw new RuntimeException("사다리의 폭은 2보다 작을 수 없습니다. 현재 값: " + width);
        }
        if (height != lines.size()) {
            throw new RuntimeException("사다리의 높이와 가로선의 갯수는 같아야 합니다. " +
                    "현재 높이: " + height + " 현재 가로선 갯수: " + lines.size());
        }
        for (Line line : lines) {
            if (width - 1 != line.getWidth()) {
                throw new RuntimeException("사다리의 폭-1 과 가로선의 폭은 같아야 합니다. " +
                        "현재 사다리의 폭: " + width + " 현재 가로선의 폭: " + line.getWidth());
            }
        }
    }

    public static Ladder createRandomLadder(int height, int width, Random random) {
        List<Line> lines = createRandomLines(height, width, random);
        return new Ladder(height, width, lines);
    }

    public static List<Line> createRandomLines(int height, int width, Random random) {
        return IntStream.range(0, height)
                .mapToObj(i -> Line.createRandomLine(width, random))
                .collect(Collectors.toList());
    }


    public int findEndPosition(int startPosition) {
        return lines.stream()
                .reduce(startPosition, (position, line) -> line.move(position), (prev, cur) -> cur);
    }


    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lines);
    }
}
