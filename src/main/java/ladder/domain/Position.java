package ladder.domain;

public class Position {
    private int row = 0;
    private int col;

    Position(int startPos) {
        this.col = startPos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (!(row ==(((Position) obj).row)))
            if (!(col ==(((Position) obj).col)))
            return false;
        return true;
    }

    public Position(int row, int col){
        this.row = row;
        this.col = col;
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
