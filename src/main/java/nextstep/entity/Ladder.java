package nextstep.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    private Ladder() {
    }

    public void initLadder(Personnel personnel, Length length) {
        IntStream.range(0, length.getLength())
                .forEach(index -> lines.add(Line.of(personnel.getPersonnel())));
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

    public static Ladder of() {
        return new Ladder();
    }
}
