package ladder_refactor.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<LadderLine> lines;

    private Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder init(int sizeOfHeight, int sizeOfPerson) {
        List<LadderLine> lines = new ArrayList<>();
        for (int i = 0; i < sizeOfHeight; i++) {
            lines.add(LadderLine.init(sizeOfPerson));
        }
        return new Ladder(lines);
    }

    public int move(int position) {
        for (LadderLine line : this.lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<LadderLine> getLines() {
        return lines;
    }
}
