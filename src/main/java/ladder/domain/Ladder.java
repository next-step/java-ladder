package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<VerticalLines> levels;

    public Ladder(int verticalLineQuantity, int verticalLineHeight) {
        List<VerticalLines> verticalLines = new ArrayList<>();
        for (int i = 0; i < verticalLineHeight; i++) {
            verticalLines.add(new VerticalLines(verticalLineQuantity));
        }
        this.levels = verticalLines;
    }

    private Ladder(List<VerticalLines> levels) {
        this.levels = levels;
    }

    public static Ladder of(List<HorizontalLines> horizontalLinesList) {
        return new Ladder(
                horizontalLinesList.stream()
                        .map(VerticalLines::of)
                        .collect(Collectors.toList())
        );
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
