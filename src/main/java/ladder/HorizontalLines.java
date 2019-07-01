package ladder;

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

    public int size() {
        return horizontalLines.size();
    }
}
