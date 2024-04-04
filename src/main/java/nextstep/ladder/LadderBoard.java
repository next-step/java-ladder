package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderBoard {
    private List<Line> ladderBoard = new ArrayList<>();

    public LadderBoard(List<Line> ladderBoard) {
        this.ladderBoard = ladderBoard;
    }

    public LadderBoard(int countOfHeight, int countOfPerson) {
        for (int i = 0; i < countOfHeight; i++) {
            ladderBoard.add(new Line(countOfPerson));
        }
    }

    public List<Line> getLadderBoard() {
        return this.ladderBoard;
    }

    public List<Point> getLine(int index) {
        return this.ladderBoard.get(index).getPoints();
    }

    public Point getPoint(int index) {
        return this.ladderBoard.get(index).getPoint(index);
    }

}
