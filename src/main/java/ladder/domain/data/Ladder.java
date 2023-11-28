package ladder.domain.data;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static final String INDENT = " ";
    private final List<Line> lines;


    public Ladder() {
        this(List.of());
    }

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public void add(Line line) {
        lines.add(line);
    }

    public List<Line> lines() {
        return lines;
    }
}
