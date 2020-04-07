package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final String HORIZONTAL_LINE_REQUIRE = "가로줄이 존재해야합니다.";
    private final List<Boolean> horizontalLines;

    public Line(List<Boolean> horizontalLines) {
        this.horizontalLines = validate(horizontalLines);
    }
    private List<Boolean> validate(List<Boolean> horizontalLines) {
        if (horizontalLines.isEmpty()) {
            throw new IllegalArgumentException(HORIZONTAL_LINE_REQUIRE);
        }
        return new ArrayList<>(horizontalLines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(horizontalLines, line.horizontalLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontalLines);
    }
}
