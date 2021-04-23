package finalRefactor.domain;

import java.util.*;

public class Ladder {

    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public Ladder(Height height, int countOfPerson) {
        this(createLines(height, countOfPerson));
    }

    private static List<LadderLine> createLines(Height height, int countOfPerson) {
        List<LadderLine> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(new LadderLine(countOfPerson));

        }
        return lines;
    }

    public int eachPositionResult(int position) {

        for (LadderLine line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<LadderLine> lines() {
        return Collections.unmodifiableList(lines);
    }

    public int size() {
        return lines.size();
    }

}
