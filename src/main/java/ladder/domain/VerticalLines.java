package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VerticalLines {
    private final List<VerticalLine> verticalLines;

    public VerticalLines(int lineQuantity) {
        this.verticalLines = new ArrayList<>();
        for (int i = 0; i < lineQuantity; i++) {
            verticalLines.add(new VerticalLine(false));
        }
    }

    private VerticalLines(List<VerticalLine> verticalLines) {
        this.verticalLines = verticalLines;
    }

    public static VerticalLines of(HorizontalLines horizontalLines) {
        return new VerticalLines(
                horizontalLines.getHorizontalLines().stream()
                        .map(HorizontalLine::hasLine)
                        .map(VerticalLine::new)
                        .collect(Collectors.toList())
        );
    }

    public int size() {
        return verticalLines.size();
    }

    public List<VerticalLine> getVerticalLines() {
        return Collections.unmodifiableList(verticalLines);
    }
}
