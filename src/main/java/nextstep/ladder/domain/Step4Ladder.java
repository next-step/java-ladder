package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nextstep.ladder.engine.FirstClassList;
import nextstep.ladder.engine.GameResult;
import nextstep.ladder.engine.Height;
import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.LadderFrame;
import nextstep.ladder.engine.LadderPointGenerateStrategy;
import nextstep.ladder.engine.Line;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.Prizes;
import nextstep.ladder.engine.RailCount;
import nextstep.ladder.engine.ResultMap;

public class Step4Ladder extends FirstClassList<Line> implements Ladder {
    private final LadderFrame ladderFrame;

    private Step4Ladder(final List<Line> lines, final LadderFrame ladderFrame) {
        super(lines);
        this.ladderFrame = ladderFrame;
    }

    public static Ladder of(LadderFrame frame, LadderPointGenerateStrategy strategy) {
        if (frame == null || strategy == null) {
            throw new IllegalArgumentException("frame or strategy cannot be null");
        }

        LadderLineBuilder builder = LadderLineBuilder.of(frame.railCount(), strategy);
        List<Line> lines = Stream.generate(builder::build)
                .limit(frame.height().toInt())
                .collect(Collectors.toList());
        return new Step4Ladder(lines, frame);
    }

    public GameResult move(Prizes prizes) {
        final ResultMap resultMap = PlayerResultMap.of(ladderFrame.prizes());
        resultMap.move(this.collect());
        return resultMap.result(ladderFrame.players());
    }

    @Override
    public Players players() {
        return ladderFrame.players();
    }

    @Override
    public Prizes prizes() {
        return ladderFrame.prizes();
    }

    @Override
    public RailCount railCount() {
        return ladderFrame.railCount();
    }

    @Override
    public Height height() {
        return ladderFrame.height();
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "ladderFrame=" + ladderFrame +
                '}';
    }
}
