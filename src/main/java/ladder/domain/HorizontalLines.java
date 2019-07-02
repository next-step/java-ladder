package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HorizontalLines {
    private final List<HorizontalLine> horizontalLines;

    private HorizontalLines(List<HorizontalLine> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public static HorizontalLines of(VerticalLines verticalLines) {
        List<HorizontalLine> horizontalLines = verticalLines.getVerticalLines().stream()
                .map(VerticalLine::getLeftHorizontalLine)
                .collect(Collectors.toList());
        return new HorizontalLines(horizontalLines);
    }

    public static HorizontalLines of(List<Boolean> booleans) {
        List<HorizontalLine> horizontalLines = booleans.stream()
                .map(HorizontalLine::of)
                .collect(Collectors.toList());
        return new HorizontalLines(horizontalLines);
    }

    public int size() {
        return horizontalLines.size();
    }

    public List<HorizontalLine> getHorizontalLines() {
        return Collections.unmodifiableList(horizontalLines);
    }
}
