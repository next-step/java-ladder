package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    private Ladder(int ladderMaxLength, int countOfPerson) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < ladderMaxLength; i++) {
            this.lines.add(new Line(countOfPerson));
        }
    }

    public static Ladder of(int ladderMaxLength, int countOfPerson) {
        return new Ladder(ladderMaxLength, countOfPerson);
    }
    public int getLadderWidth(){
        return lines.stream()
                .map(line -> line.getSize())
                .findFirst()
                .orElse(0);

    }
    public int getLadderHeight(){
        return lines.size();
    }

    public boolean isDraw(int row, int column) {
        if (column == 0)
            return false;
        if (row % 2 == 0 && column % 2 == 1)
            return true;
        if (row % 2 == 1 && column % 2 == 0)
            return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }


}
