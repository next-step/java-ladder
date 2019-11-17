package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLadderLines() {
        return new ArrayList<>(lines);
    }

    public int getResult(int index) {
        for (Line ladderLine : lines) {
            index += move(ladderLine, index);
        }
        return index;
    }

    private int move(Line line, int index) {
        if (index == 0) {
            return moveToFirstIndex(line, index);
        }
        return MovingOperator.getPosition(new Moving(line.isPoint(index - 1), line.isPoint(index)));
    }

    private int moveToFirstIndex(Line line, int index) {
        if (line.isPoint(index)) {
             return MovingOperator.getPosition(Moving.right());
        } return MovingOperator.getPosition(Moving.stay());
    }
}
