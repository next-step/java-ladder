package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderBoard {
    private List<Line> ladderBoard = new ArrayList<>();

    public LadderBoard(List<Line> ladderBoard) {
        this.ladderBoard = ladderBoard;
    }

    public LadderBoard(int column, int row) {
        for (int i = 0; i < column; i++) {
            ladderBoard.add(new Line(row));
        }
    }

    public List<Line> getLadderBoard() {
        return this.ladderBoard;
    }

    public Line getLine(int index) {
        return this.ladderBoard.get(index);
    }

}
