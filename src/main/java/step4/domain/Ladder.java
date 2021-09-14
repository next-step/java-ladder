package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder init(int height, int sizeOfPerson) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.init(sizeOfPerson));
        }
        return new Ladder(ladderLines);
    }

    public int move(int target) {
        int height = ladderLines.size();
        for (int i = 0; i < height; i++) {
            LadderLine ladderLine = ladderLines.get(i);
            target = ladderLine.move(target);
        }
        return target;
    }
}
