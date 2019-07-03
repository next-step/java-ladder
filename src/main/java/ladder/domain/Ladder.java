package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<HorizontalLines> horizontalLinesByLevel;

    public Ladder(int lineQuantity, int lineHeight) {
        this.horizontalLinesByLevel = IntStream.range(0, lineHeight)
                .mapToObj(i -> new HorizontalLines(lineQuantity))
                .collect(Collectors.toList());
    }

    private Ladder(List<HorizontalLines> horizontalLinesByLevel) {
        this.horizontalLinesByLevel = horizontalLinesByLevel;
    }

    public static Ladder of(List<HorizontalLines> horizontalLinesList) {
        return new Ladder(horizontalLinesList);
    }

    public HorizontalLines horizontalLinesByLevel(int level) {
        return horizontalLinesByLevel.get(level);
    }

    public int height() {
        return horizontalLinesByLevel.size();
    }
}
