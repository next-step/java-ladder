package ladder.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder implements Iterable<HorizontalLine> {

    public static final int MINIMUM_HEIGHT = 1;
    private final List<HorizontalLine> lines;

    public Ladder(int countOfPerson, int height, LineStrategy lineStrategy) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 양수 값을 가져야합니다.");
        }
        lines = IntStream.rangeClosed(1, height)
            .mapToObj(i -> new HorizontalLine(countOfPerson, lineStrategy))
            .collect(Collectors.toList());
    }

    public Ladder(List<HorizontalLine> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public Iterator<HorizontalLine> iterator() {
        return lines.iterator();
    }

}
