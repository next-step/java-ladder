package ladder.domain;

import ladder.dto.response.LinesDto;

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

    public LinesDto getLinesDto() {
        return lines.stream()
                .map(Line::getLineDto)
                .collect(collectingAndThen(toList(), LinesDto::new));
    }
}
