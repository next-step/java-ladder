package ladder.domain.data;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static final String INDENT = " ";
    private List<Line> lines;
    private Goals goals;

    public Ladder() {
        this.lines = new ArrayList<>();
    }

    public Ladder(Goals goals) {
        this(List.of(), goals);
    }

    public Ladder(List<Line> lines, Goals goals) {
        this.lines = new ArrayList<>(lines);
        this.goals = goals;
    }

    public void add(Line line) {
        lines.add(line);
    }

    public List<Line> lines() {
        return lines;
    }
}
