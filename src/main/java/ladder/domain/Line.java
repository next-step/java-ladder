package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final String WIDTH_REQUIRED = "가로라인이 존재해야합니다.";
    private final List<Boolean> widthLines;

    public Line(List<Boolean> width) {
        this.widthLines = validate(width);
    }
    private List<Boolean> validate(List<Boolean> horizontalLines) {
        if (horizontalLines.isEmpty()) {
            throw new IllegalArgumentException(WIDTH_REQUIRED);
        }
        return new ArrayList<>(horizontalLines);
    }

    public List<Boolean> getWidthLines() {
        return widthLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(widthLines, line.widthLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(widthLines);
    }
}
