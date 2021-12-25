package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.engine.FirstClassList;
import nextstep.ladder.engine.GameResult;
import nextstep.ladder.engine.Height;
import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.LadderFrame;
import nextstep.ladder.engine.Line;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.LadderPointGenerateStrategy;
import nextstep.ladder.engine.Prizes;

public class Step4Ladder extends FirstClassList<Line> implements Ladder {
    private final LadderFrame ladderFrame;

    private Step4Ladder(final List<Line> lines, final LadderFrame ladderFrame) {
        super(lines);
        this.ladderFrame = ladderFrame;
    }

    public static Step4Ladder of(final LadderFrame ladderFrame, final Height ladderHeight, LadderPointGenerateStrategy strategy) {
        if (ladderFrame == null || ladderHeight == null) {
            throw new IllegalArgumentException("rail count or height cannot be null");
        }

        // todo lambda style
        List<Line> lines = IntStream.range(0, ladderHeight.toInt())
                .mapToObj(index -> LadderLine.init(ladderFrame.railCount(), strategy))
                .collect(Collectors.toList());
        return new Step4Ladder(lines, ladderFrame);
    }

    public static Step4Ladder of(final Step4LadderFrame step4LadderFrame, final int height, final LadderPointGenerateStrategy strategy) {
        return of(step4LadderFrame, LadderHeight.of(height), strategy);
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
