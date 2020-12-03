package ladder;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class HorizontalLine {

    private final List<Boolean> line;

    private HorizontalLine(List<Boolean> line) {
        this.line = line;
    }

    public static HorizontalLine of(int numUser) {
        return IntStream.range(0, numUser)
                .mapToObj(x -> false)
                .collect(collectingAndThen(toList(), HorizontalLine::new));
    }

    public static HorizontalLine of(List<Boolean> line) {
        return new HorizontalLine(line);
    }

    public void shuffle(HowToConnect strategy) {
        for (int i = 0; i < line.size(); i++) {
            boolean leftSideStatus = translateLeftSideStatus(i);
            this.line.set(i, strategy.connect(leftSideStatus));
        }
    }

    private boolean translateLeftSideStatus(int idx) {
        if (idx == 0) {
            return false;
        }
        return line.get(idx - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorizontalLine that = (HorizontalLine) o;
        return line.equals(that.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
