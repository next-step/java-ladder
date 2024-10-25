package ladder;

import java.util.*;

public class Line {

    private List<Boolean> lines;

    public Line(int participantCount) {
        this.lines = initializeLines(participantCount);
    }

    private List<Boolean> initializeLines(int participantCount) {
        return new ArrayList<>(Collections.nCopies(participantCount - 1, false));
    }

    public void createLine(int ladderCount) {
        for (int i = 0; i < ladderCount; i++) {
            createLineForLadder();
        }
    }

    private void createLineForLadder() {
        Random random = new Random();
        for (int j = 0; j < lines.size()-1; j++) {
            boolean canCreateLine = (j == 0 || !lines.get(j - 1)) && random.nextBoolean();
            lines.set(j, canCreateLine);
        }
    }

    public List<Boolean> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int size() {
        return lines.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(lines, line.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lines);
    }


}
