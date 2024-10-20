package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> lines;
    private int height;

    public Ladder() {
        this(new ArrayList<>(), 0);
    }

    public Ladder(List<Line> lines, int height) {
        this.lines = lines;
        this.height = height;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
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
        return getHeight() == ladder.getHeight() && Objects.equals(getLines(), ladder.getLines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLines(), getHeight());
    }
}
