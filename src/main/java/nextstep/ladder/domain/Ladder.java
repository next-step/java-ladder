package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    public Ladder(final PlayerCount playerCount, final Height height, final Supplier<Boolean> linePredicate) {
        for (int i = 0; i < height.height(); i++) {
            lines.add(new Line(playerCount, linePredicate));
        }
    }

    public List<Line> lines() {
        return lines;
    }
}
