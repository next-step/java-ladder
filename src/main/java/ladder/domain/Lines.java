package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines {
    private List<Line> lines = new ArrayList<>();

    public Lines() {

    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public void createLines(int userCount, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(userCount));
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
