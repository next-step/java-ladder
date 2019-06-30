package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(int lineQuantity, int lineLength) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < lineQuantity; i++) {
            lines.add(new Line(lineLength));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int size() {
        return lines.size();
    }
}
