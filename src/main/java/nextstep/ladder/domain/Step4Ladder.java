package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.engine.FirstClassList;
import nextstep.ladder.engine.GameResult;
import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.LadderPointGenerateStrategy;

public class Step4Ladder extends FirstClassList<LadderLine> implements Ladder {
    private final LadderFrame ladderFrame;

    private Step4Ladder(final List<LadderLine> lines, final LadderFrame ladderFrame) {
        super(lines);
        this.ladderFrame = ladderFrame;
    }

    public static Step4Ladder of(final LadderFrame ladderFrame, final Height height, LadderPointGenerateStrategy strategy) {
        if (ladderFrame == null || height == null) {
            throw new IllegalArgumentException("rail count or height cannot be null");
        }

        // todo lambda style
        List<LadderLine> lines = IntStream.range(0, height.toInt())
                .mapToObj(index -> LadderLine.init(ladderFrame.railCount(), strategy))
                .collect(Collectors.toList());
        return new Step4Ladder(lines, ladderFrame);
    }

    public static Step4Ladder of(final LadderFrame ladderFrame, final int height, final LadderPointGenerateStrategy strategy) {
        return of(ladderFrame, Height.of(height), strategy);
    }

    public GameResult result() {
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
    public LadderPrizes prizes() {
        return ladderFrame.prizes();
    }

    public int downToResult(int index) {
        // todo lambda style with stream
        for(LadderLine ladderLine: collect()) {
            index = ladderLine.move(index).toInt();
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
