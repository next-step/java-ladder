package refactor.domain;

import refactor.domain.pointGenerate.PointStrategy;
import refactor.domain.pointGenerate.RandomPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder init(int ladderHeight, int sizeOfPerson) {
        PointStrategy pointStrategy = new RandomPoint();
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladderLines.add(LadderLine.init(sizeOfPerson, pointStrategy));
        }
        return new Ladder(ladderLines);
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }
}
