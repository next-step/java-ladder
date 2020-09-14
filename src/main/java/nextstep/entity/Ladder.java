package nextstep.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<List<Boolean>> getLinesStatus() {
        return this.lines.stream().map(Line::getPedalsStatus).collect(Collectors.toList());
    }

    public int play(int targetIndex) {
        AtomicInteger previousIndex = new AtomicInteger(targetIndex);
        lines.forEach(line -> {
            int nextIndex = line.play(previousIndex.get());
            previousIndex.set(nextIndex);
        });
        return previousIndex.get();
    }

    public static Ladder of(Length length, Personnel personnel) {
        List<Line> lines = IntStream.range(0, length.getLength())
                .mapToObj(index -> Line.of(personnel.getPersonnel()))
                .collect(Collectors.toList());
        return new Ladder(lines);
    }
}
