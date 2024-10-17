package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int playerSize) {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < height; index++) {
            lines.add(new Line(playerSize - 1, new RandomLineGenerator()));
        }
        this.lines = lines;
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Ladder))
            return false;
        Ladder ladder = (Ladder)o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lines);
    }
}
