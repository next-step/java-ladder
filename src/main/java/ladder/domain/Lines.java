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
            if (index == 0) {
                if (ladderLine.isPoint(index)) {
//                        Moving.getPosition(Move.right());
                    index += Moving.getPosition(Move.right());
                } else {
//                        Moving.getPosition(Move.stay());
                    index += Moving.getPosition(Move.stay());
                }
            } else {
                index += Moving.getPosition(new Move(ladderLine.isPoint(index - 1), ladderLine.isPoint(index)));
                //                Moving.getPosition(new Move(ladderLine.isPoint(i-1), ladderLine.isPoint(i)));
            }
        }
        return index;
    }
}
