package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<VerticalLines> levels;

    public Ladder(int verticalLineQuantity, int verticalLineHeight) {
        List<VerticalLines> verticalLines = new ArrayList<>();
        for (int i = 0; i < verticalLineHeight; i++) {
            verticalLines.add(new VerticalLines(verticalLineQuantity));
        }
        this.levels = verticalLines;
    }

    public VerticalLines verticalLinesByLevel(int level) {
        return levels.get(level);
    }

    public HorizontalLines horizontalLinesByLevel(int level) {
        return HorizontalLines.of(verticalLinesByLevel(level));
    }

    public int height() {
        return levels.size();
    }
}
