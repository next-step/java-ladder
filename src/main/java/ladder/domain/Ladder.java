package ladder.domain;

import ladder.domain.generator.PointGenerator;
import ladder.domain.generator.RandomPointGenerator;

public class Ladder {

    private final LadderInfo ladderInfo;
    private final Lines lines;

    public Ladder(LadderInfo ladderInfo) {

        this(ladderInfo, new RandomPointGenerator());
    }

    public Ladder(LadderInfo ladderInfo, PointGenerator pointGenerator) {

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
