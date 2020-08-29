package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int MIN_WIDTH = 1;
    private static final int MIN_COUNT_OF_POINTS = 2;
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int width, int countOfPoints, LadderGenerateStrategy ladderGenerateStrategy) {
        validateLadder(width, countOfPoints);
        List<Line> lines = new ArrayList<>();
        int countOfStep = countOfPoints - 1;

        for (int i = 0; i < width; i++) {
            lines.add(new Line(countOfStep, ladderGenerateStrategy));
        }

        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private static void validateLadder(int width, int countOfPoints) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_WIDTH + "이상입니다.");
        }

        if (countOfPoints < MIN_COUNT_OF_POINTS) {
            throw new IllegalArgumentException("사다리 게임 최소 유저수 " + MIN_COUNT_OF_POINTS + "이상입니다.");
        }
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
        return Objects.hash(lines);
    }

}
