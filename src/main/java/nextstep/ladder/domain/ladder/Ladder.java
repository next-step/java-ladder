package nextstep.ladder.domain.ladder;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private Height height;
    private List<ColumnLine> columnLines = new LinkedList<>();

    public Ladder(List<ColumnLine> columnLines) {
        this.columnLines = columnLines;
    }

    public Ladder(int height, int countOfUser) {
        this.height = new Height(height);
        createColumnLines(countOfUser);
        drawRowLines();
    }

    private void drawRowLines() {
        for (int index = 0; index < columnLines.size()-1; index++) {
            columnLines.get(index).draw(columnLines.get(index+1));
        }
    }

    private void createColumnLines(int countOfUser) {
        for (int i = 0; i < countOfUser; i++) {
            columnLines.add(new ColumnLine(height));
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
        return Objects.equals(height, ladder.height) && Objects.equals(columnLines, ladder.columnLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, columnLines);
    }
}
