package nextstep.ladder;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Lines {

    private final List<Boolean> lines;

    public Lines(List<Boolean> lines) {
        if (isConsecutive(lines)) {
            throw new IllegalArgumentException("다리는 연속 될 수 없습니다.");
        }
        this.lines = lines;
    }

    private boolean isConsecutive(List<Boolean> lines) {
        return IntStream.range(0, lines.size() - 1).anyMatch(i -> lines.get(i) && lines.get(i + 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
