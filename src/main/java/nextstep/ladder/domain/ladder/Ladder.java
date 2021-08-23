package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int DEFAULT_INDEX = 0;
    private Height height;
    private List<ColumnLine> columnLines = new LinkedList<>();

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

    public void play(List<User> playUsers) {
        for (int indexOfUsers = 0; indexOfUsers < playUsers.size(); indexOfUsers++) {
            int indexOfColumnLine = playUsers.get(indexOfUsers).getIndexOfColumnLine();
            moveUser(playUsers.get(indexOfUsers), indexOfColumnLine);
        }
        System.out.println();
    }

    private void moveUser(User playUser, int indexOfColumnLine) {
        for (int indexOfHeight = 0; indexOfHeight < height.getValue(); indexOfHeight++) {
            indexOfColumnLine = getIndexOfColumnLine(indexOfColumnLine, indexOfHeight);
            playUser.move(indexOfColumnLine);
        }
    }

    private int getIndexOfColumnLine(int indexOfColumnLine, int indexOfHeight) {
        if (columnLines.get(indexOfColumnLine)
                .getPointOfDirection(indexOfHeight)
                .equals(Direction.RIGHT)) {
            return ++indexOfColumnLine;
        }
        if (columnLines.get(indexOfColumnLine)
                .getPointOfDirection(indexOfHeight)
                .equals(Direction.LEFT)) {
            return --indexOfColumnLine;
        }
        return indexOfColumnLine;
    }

    public String getResultOfLine(int lineOfIndex) {
        return columnLines.get(lineOfIndex).getResult();
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
