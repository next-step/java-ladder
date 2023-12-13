package nextstep.ladder.domain.concrete;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.strategy.LadderCreateStrategy;
import nextstep.ladder.domain.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class NormalLadderCreateStrategy implements LadderCreateStrategy {
    private final LineCreateStrategy lineCreateStrategy;

    public NormalLadderCreateStrategy(LineCreateStrategy lineCreateStrategy) {
        this.lineCreateStrategy = lineCreateStrategy;
    }

    @Override
    public Ladder create(Players players, Height height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.height(); i++) {
            Line line = lineCreateStrategy.createLine(players.size());
            lines.add(line);
        }

        return new Ladder(lines);
    }
}
