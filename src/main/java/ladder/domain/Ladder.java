package ladder.domain;

import ladder.domain.generator.BooleanGenerator;
import ladder.domain.generator.RandomBooleanGenerator;

public class Ladder {

    private final LadderInfo ladderInfo;
    private final Lines lines;

    public Ladder(LadderInfo ladderInfo) {

        this(ladderInfo, new RandomBooleanGenerator());
    }

    public Ladder(LadderInfo ladderInfo, BooleanGenerator booleanGenerator) {

        this.ladderInfo = ladderInfo;
        this.lines = Lines.of(ladderInfo, booleanGenerator);
    }

    public Lines getLines() {

        return lines;
    }

    public LadderInfo getLadderInfo() {

        return ladderInfo;
    }
}
