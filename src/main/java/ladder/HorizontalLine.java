package ladder;

import java.util.ArrayList;
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

    public void shuffle(HowToConnect connectionMode) {
        for (int i = 0; i < line.size(); i++) {
            boolean leftSideStatus = checkLeftSideStatus(i);
            this.line.set(i, connectionMode.needToConnect(leftSideStatus));
        }
    }

    private boolean checkLeftSideStatus(int index) {
        if (index == 0) {
            return false;
        }
        return this.line.get(index - 1);
    }

    public List<Boolean> getLine() {
        return new ArrayList<>(this.line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HorizontalLine that = (HorizontalLine) o;
        return line.equals(that.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
