package ladder.domain;

import ladder.dto.LinesDto;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {
    private final List<Line> lines;

    Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int sizeOfPersons, int height, DirectionStrategy directionStrategy) {
        lines = Stream.generate(() -> {
            Line line = IntStream.range(0, sizeOfPersons)
                    .mapToObj(position -> new Point(position, directionStrategy.get()))
                    .collect(collectingAndThen(toList(), Line::new));
            directionStrategy.reset();
            return line;
        }).limit(height)
                .collect(toList());
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
