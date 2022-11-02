package ladder.domain.fixtrue;

import ladder.domain.Line;
import ladder.domain.LinesGenerable;

import java.util.ArrayList;
import java.util.List;

public class FixedLinesGenerator implements LinesGenerable {

    @Override
    public List<Line> generate() {
        List<Line> lines = new ArrayList<>();
        lines.add(Line.from(List.of(true, false, true)));
        lines.add(Line.from(List.of(false, true, false)));
        lines.add(Line.from(List.of(true, false, false)));
        return lines;
    }
}
