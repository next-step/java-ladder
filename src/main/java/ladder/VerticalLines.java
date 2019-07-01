package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalLines {
    private final List<VerticalLine> verticalLines;

    public VerticalLines(int lineQuantity, int lineLength) {
        this.verticalLines = new ArrayList<>();
        for (int i = 0; i < lineQuantity; i++) {
            verticalLines.add(new VerticalLine(lineLength, false));
        }
    }

    public int size() {
        return verticalLines.size();
    }

    public List<VerticalLine> getVerticalLines() {
        return Collections.unmodifiableList(verticalLines);
    }
}
