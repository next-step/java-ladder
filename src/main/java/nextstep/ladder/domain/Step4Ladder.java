package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        // todo wrapping indexes
        List<Line> lines = IntStream.range(0, frame.height().toInt())
        // todo lambda style
                .mapToObj(index -> LadderLine.init(frame.railCount(), strategy))
                .collect(Collectors.toList());
        return new Step4Ladder(lines, frame);
    }

    public GameResult move(Prizes prizes) {
        List<Integer> indexes = IntStream.range(0, ladderFrame.railCount().toInt())
                .mapToObj(this::downToResult)
                .collect(Collectors.toList());

        return LadderGameResult.of(ladderFrame, indexes);
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

    public int downToResult(int index) {
        // todo lambda style with stream
        for(Line line: collect()) {
            index = line.move(index).toInt();
        }

        return index;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "ladderFrame=" + ladderFrame +
                '}';
    }
}
