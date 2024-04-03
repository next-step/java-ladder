package nextstep.ladder;

import java.util.List;
import java.util.stream.IntStream;

public class LadderBoard {
    private List<Line> ladderBoard;

    public LadderBoard(List<Line> ladderBoard) {
        this.ladderBoard = ladderBoard;
    }

    public List<Line> getLadderBoard() {
        return ladderBoard;
    }

}
