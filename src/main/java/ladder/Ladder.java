package ladder;

import ladder.util.LadderGameUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {
    public static final int ZERO = 0;

    private final List<Line> value;

    public Ladder(int width, int height) {
        this(LadderGameUtil.autoLadderValue(width, height));
    }

    public Ladder(List<Line> value) {
        validate(value);
        this.value = value;
    }

    private void validate(List<Line> value) {
        if (value.size() == ZERO) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(value, ladder.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return this.value.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }

    public List<Line> getLines() {
        return this.value;
    }
}
