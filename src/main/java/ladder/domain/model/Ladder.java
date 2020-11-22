package ladder.domain.model;

import ladder.dto.LinesDto;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int move(int position) {
        return lines.stream()
                .reduce(position, (acc, line) -> line.move(acc), Integer::sum);
    }

    public LinesDto exportLinesDto() {
        return lines.stream()
                .map(Line::exportLineDto)
                .collect(collectingAndThen(toList(), LinesDto::new));
    }
}
