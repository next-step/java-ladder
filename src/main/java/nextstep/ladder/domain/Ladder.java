package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private Lines lines;

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int countOfPerson, List<Line> lines) {
        validateHeight(height, lines);
        return new Ladder(Lines.of(countOfPerson, lines));
    }

    private static void validateHeight(int height, List<Line> lines) {
        if (lines.size() != height) {
            throw new IllegalArgumentException("사다리 높이와 일치하지 않습니다.");
        }
    }

    public List<Pipes> convertToPipes() {
        return lines.convertToPipes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return lines.equals(ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
