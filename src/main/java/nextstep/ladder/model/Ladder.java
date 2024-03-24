package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    public static Ladder from(Line... lines) {
        return new Ladder(List.of(lines));
    }

    public static Ladder of(int height, int countOfPerson) {
        return new Ladder(create(height, countOfPerson));
    }

    private static List<Line> create(int height, int countOfPerson) {
        List<Line> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            result.add(Line.from(countOfPerson));
        }
        return result;
    }

    private Ladder(List<Line> lines) {
        assertNullOrEmpty(lines);
        this.lines = lines;
    }

    private static void assertNullOrEmpty(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("라인 정보가 비어있습니다");
        }
    }

    public int height() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Ladder ladder = (Ladder) other;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public int move(int position) {
        int result = position;
        for (Line line : lines) {
            result = line.move(result);
        }

        return result;
    }
}
