package ladder.domain;

import ladder.domain.generator.PointGenerator;
import ladder.domain.generator.RandomPointGenerator;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final PointGenerator pointGenerator;
    private final LadderInfo ladderInfo;
    private final Lines lines;

    public Ladder(LadderInfo ladderInfo) {

        this.pointGenerator = new RandomPointGenerator();
        this.ladderInfo = ladderInfo;
        this.lines = Lines.of(ladderInfo, pointGenerator);
    }

    public Lines getLines() {

        return lines;
    }

    public LadderInfo getLadderInfo() {

        return ladderInfo;
    }
}
