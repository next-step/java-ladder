package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;

public class Lines {
    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines createVertical(Height height, int countOfPerson){
        return Stream.generate(() -> Line.of(countOfPerson))
                .limit(height.getHeight())
                .collect(collectingAndThen(Collectors.toList(),Lines::new));
    }

    public List<Point> createHorizontal() {
        return lines.stream()
                    .flatMap(line -> line.Stream())
                    .collect(Collectors.toList());
    }
}
