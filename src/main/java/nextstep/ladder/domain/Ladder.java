package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.engine.LadderPointGenerateStrategy;

public class Ladder extends FirstClassList<LadderLine> implements nextstep.ladder.engine.Ladder {
    private final LadderFrame ladderFrame;

    private Ladder(final List<LadderLine> lines, final LadderFrame ladderFrame) {
        super(lines);
        this.ladderFrame = ladderFrame;
    }

    public static Ladder of(final LadderFrame ladderFrame, final Height height, LadderPointGenerateStrategy strategy) {
        if (ladderFrame == null || height == null) {
            throw new IllegalArgumentException("rail count or height cannot be null");
        }

        List<LadderLine> lines = IntStream.range(0, height.toInt())
                .mapToObj(index -> LadderLine.init(ladderFrame.railCount(), strategy))
                .collect(Collectors.toList());
        return new Ladder(lines, ladderFrame);
    }

    public static Ladder of(final LadderFrame ladderFrame, final int height, final LadderPointGenerateStrategy strategy) {
        return of(ladderFrame, Height.of(height), strategy);
    }

    public ResultOfGame resultOfGame() {
        List<Integer> indexes = IntStream.range(0, ladderFrame.railCount().toInt())
                .mapToObj(this::downToResult)
                .collect(Collectors.toList());

        return ResultOfGame.of(ladderFrame.players(), ladderFrame.resultsOfGame(indexes));
    }

    @Override
    public Players players() {
        return ladderFrame.players();
    }

    @Override
    public Results results() {
        return ladderFrame.results();
    }

    public int downToResult(int index) {
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
