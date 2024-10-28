package nextstep.ladder.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> lines;

    public Ladder() {
        this(new ArrayList<>());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int move(int startIdx) {
        return lines.stream()
                .reduce(startIdx,
                        (result, line) -> line.move(result),
                        (result1, result2) -> result1);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ladder)) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(getLines(), ladder.getLines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLines());
    }
}
