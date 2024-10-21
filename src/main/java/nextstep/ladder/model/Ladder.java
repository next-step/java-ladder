package nextstep.ladder.model;

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
