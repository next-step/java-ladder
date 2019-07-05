package ladder.domain;

public class Position {
    private int row = 0;
    private int col;

    Position(int startPos) {
        this.col = startPos;
    }

    public void moveLeft() {
        row += 1;
        col -= 1;
    }

    public void moveStraight() {
        row += 1;
    }

    public void moveRight() {
        row += 1;
        col += 1;
    }

    public boolean matchRow(int row) {
        return this.row == row;
    }

    public boolean matchCol(int col) {
        return this.col == col;
    }

    public boolean matchNextCol(int col) {
        return this.col + 1 == col;
    }
}
