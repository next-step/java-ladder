package ladder.domain.data;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static final String INDENT = " ";
    private final List<Line> lines;
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

    public Goal run(int index) {
        int newIndex = index;
        for (Line line: lines) {
            newIndex = line.run(newIndex);
        }
        return goals.get(newIndex);
    }

    public void add(Line line) {
        lines.add(line);
    }

    public List<Line> lines() {
        return lines;
    }
}
