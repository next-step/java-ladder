package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<VerticalLines> levels;

    public Ladder(int verticalLineQuantity, int verticalLineHeight) {
        this.levels = IntStream.range(0, verticalLineHeight)
                .mapToObj(i -> new VerticalLines(verticalLineQuantity))
                .collect(Collectors.toList());
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
