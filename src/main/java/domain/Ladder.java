package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder ofGroup(int height, List<NameTag> nameTagGroup) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.ofCount(nameTagGroup.size()));
        }
        return new Ladder(lines);
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getFinalPosition(int index) {
        for (Line line : lines) {
            index = line.getNextPosition(index);
        }
        return index;
    }

}
