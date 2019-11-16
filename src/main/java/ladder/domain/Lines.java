package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return Moving.getPosition(new Move(line.isPoint(index - 1), line.isPoint(index)));
    }

    private int moveToFirstIndex(Line line, int index) {
        if (line.isPoint(index)) {
             return Moving.getPosition(Move.right());
        } return Moving.getPosition(Move.stay());
    }
}
