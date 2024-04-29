package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> ladderBoard = new ArrayList<>();

    public Ladder(List<Line> ladderBoard) {
        this.ladderBoard = ladderBoard;
    }

    public Ladder(int column, int row) {
        for (int i = 0; i < column; i++) {
            ladderBoard.add(new Line(row));
        }
    }

    public List<Line> getLadderBoard() {
        return this.ladderBoard;
    }

}
