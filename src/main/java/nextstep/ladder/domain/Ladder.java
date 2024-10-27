package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Line.createLines;

public class Ladder {
    private final int width;
    private final List<Line> lines;

    public Ladder(int width, List<Line> lines) {
        if (!isValidLines(lines, width - 1)) {
            throw new IllegalArgumentException("사다리 연결부의 개수가 유효하지 않습니다.");
        }

        this.width = width;
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder createLadder(int height, int width) {
        return new Ladder(width, createLines(height, width - 1));
    }

    private static boolean isValidLines(List<Line> lines, int countOfLink) {
        return lines.stream()
                .allMatch(line -> line.hasCountOfLink(countOfLink));
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public List<Integer> play() {
        AtomicReference<List<Integer>> numbers = new AtomicReference<>(IntStream.range(0, width)
                .boxed()
                .collect(Collectors.toList()));

        lines.forEach(line -> numbers.set(line.move(numbers.get())));

        return numbers.get();
    }
}
