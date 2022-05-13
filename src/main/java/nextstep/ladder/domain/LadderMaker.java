package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {
    private final LineMaker lineMaker;

    public LadderMaker(LineMaker lineMaker) {
        this.lineMaker = lineMaker;
    }

    public Ladder makeLadder(String height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(height); i++) {
            lines.add(lineMaker.makeLine());
        }
        return new Ladder(lines);
    }

}
