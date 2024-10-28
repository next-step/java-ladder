package ladder;

import java.util.*;

public class Line {

    private final List<Boolean> lines;

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
        for (int j = 0; j < lines.size()-1; j++) {
            lines.set(j, canCreateLine(j));
        }
    }

    private boolean canCreateLine(int lineIndex) {
        Random random = new Random();
        return (lineIndex == 0 || !lines.get(lineIndex-1)) && random.nextBoolean();
    }

    public List<Boolean> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int size() {
        return lines.size();
    }

    public Boolean lineStatus(int index) {
        return lines.get(index);
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
