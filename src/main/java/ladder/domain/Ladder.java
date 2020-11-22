package ladder.domain;

import ladder.dto.LinesDto;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, Supplier<Line> supplier) {
        lines = IntStream.range(0, height)
                .mapToObj(i -> supplier.get())
                .collect(Collectors.toList());
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
