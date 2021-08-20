package nextstep.ladder.domain.ladder;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private Height height;
    private List<ColumnLine> columnLines = new LinkedList<>();
    private final int DEFAULT_INDEX = 0;

    public Ladder(int height, List<ColumnLine> columnLines) {
        this.height = new Height(height);
        this.columnLines = columnLines;
    }

    public Ladder(List<ColumnLine> completedColumnLines) {
        columnLines = completedColumnLines;
        height = new Height(completedColumnLines.get(DEFAULT_INDEX).getPoints().size());
    }

    public void drawRowLines() {
        for (int index = 0; index < columnLines.size()-1; index++) {
            columnLines.get(index).draw(columnLines.get(index+1));
        }
    }

    public List<ColumnLine> getLines() {
        return columnLines;
    }

    public int getHeight() {
        return height.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return DEFAULT_INDEX == ladder.DEFAULT_INDEX && Objects.equals(height, ladder.height) && Objects.equals(columnLines, ladder.columnLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, columnLines, DEFAULT_INDEX);
    }
}
