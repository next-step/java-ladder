package nextstep.ladder.model.v2;

import nextstep.ladder.model.api.Ladder;
import nextstep.ladder.model.api.LadderBuilder;

import java.util.ArrayList;
import java.util.List;

public class LateralLadderBuilder implements LadderBuilder {
    private final LadderPointGenerator generator;

    public LateralLadderBuilder(LadderPointGenerator generator) {
        this.generator = generator;
    }

    @Override
    public Ladder build(int width, int height) {
        List<LadderLine> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(LadderLine.init(width, generator));
        }

        return new LateralLadder(lines);
    }
}
