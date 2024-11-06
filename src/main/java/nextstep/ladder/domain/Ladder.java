package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Line.createLines;

public class Ladder {
    private final int countOfPoint;
    private final List<Line> lines;

    private List<Integer> result;

    public Ladder(int countOfPoint, List<Line> lines) {
        if (isInvalidLines(lines, countOfPoint - 1)) {
            throw new IllegalArgumentException("사다리 연결부의 개수가 유효하지 않습니다.");
        }

        this.countOfPoint = countOfPoint;
        this.lines = new ArrayList<>(lines);
    }

    public Ladder(int countOfPoint, List<Line> lines, List<Integer> result) {
        if (isInvalidLines(lines, countOfPoint - 1)) {
            throw new IllegalArgumentException("사다리 연결부의 개수가 유효하지 않습니다.");
        }

        this.countOfPoint = countOfPoint;
        this.lines = new ArrayList<>(lines);
        this.result = result;
    }

    public static Ladder createLadder(int height, int width) {
        return new Ladder(width, createLines(height, width - 1));
    }

    private static boolean isInvalidLines(List<Line> lines, int countOfLink) {
        return !lines.stream()
                .allMatch(line -> line.hasCountOfLink(countOfLink));
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public void move() {
        AtomicReference<List<Integer>> numbers = new AtomicReference<>(IntStream.range(0, countOfPoint)
                                                                               .boxed()
                                                                               .collect(Collectors.toList()));

        lines.forEach(line -> numbers.set(line.move(numbers.get())));

        result = numbers.get();
    }

    public int getEndPoint(int startPoint) {
        return result.indexOf(startPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ladder ladder = (Ladder) o;
        return countOfPoint == ladder.countOfPoint && Objects.equals(lines, ladder.lines) &&
               Objects.equals(result, ladder.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfPoint, lines, result);
    }
}
