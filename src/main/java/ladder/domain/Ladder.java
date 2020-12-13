package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    public Ladder(int sizeOfPerson, int ladderMaxHeight) {
        this.lines = IntStream.range(0, ladderMaxHeight)
                .mapToObj(i -> Line.init(sizeOfPerson))
                .collect(Collectors.toList());
    }

    public Ladder(List<Line> lines){
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int climb(int startIndex) {

        AtomicInteger moveIndex = new AtomicInteger(startIndex);

        lines.forEach(line -> moveIndex.set(line.move(moveIndex.get())));

        return moveIndex.get();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

}
