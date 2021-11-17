package nextstep.step2.domain;

import nextstep.step2.dto.LadderInformation;
import nextstep.step2.vo.*;

public class Ladder {

    private final Lines lines;
    private final Names names;

    private Ladder(Lines lines, Names names) {
        this.lines = lines;
        this.names = names;
    }

    public static Ladder create(Lines lines, Names names) {
        return new Ladder(lines, names);
    }

    public static Ladder createWithLadderInformation(LadderInformation info, BooleanGenerateStrategy strategy) {
        Names names = info.getNames();
        Width width = Width.create(info.getNames().size());
        Height height = info.getHeight();
        return create(Lines.createWithHeightANdWidth(height, width, strategy), names);
    }

}
