package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.engine.LadderPointGenerateStrategy;

public class Ladder extends FirstClassList<LadderLine> implements nextstep.ladder.engine.Ladder {
    private Ladder(final List<LadderLine> lines) {
        super(lines);
    }

    public static Ladder of(final RailCount railCount, final Height height, LadderPointGenerateStrategy strategy) {
        if (railCount == null || height == null) {
            throw new IllegalArgumentException("rail count or height cannot be null");
        }

        List<LadderLine> lines = IntStream.range(0, height.toInt())
                .mapToObj(index -> LadderLine.init(railCount, strategy))
                .collect(Collectors.toList());
        return new Ladder(lines);
    }

    public static Ladder of(final int railCount, final int height, final LadderPointGenerateStrategy strategy) {
        return of(RailCount.of(railCount), Height.of(height), strategy);
    }

    public ResultOfGame resultOfGame(LadderFrame ladderFrame) {
        List<Integer> indexes = IntStream.range(0, ladderFrame.size())
                .mapToObj(this::downToResult)
                .collect(Collectors.toList());

        return ResultOfGame.of(ladderFrame.players(), ladderFrame.resultsOfGame(indexes));
    }

    public int downToResult(int index) {
        for(LadderLine ladderLine: collect()) {
            index = ladderLine.move(index).toInt();
        }

        return index;
    }

    @Override
    public String toString() {
        return "Ladder {" +
                super.toString() +
                "}";
    }
}
