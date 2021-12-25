package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.engine.FirstClassList;
import nextstep.ladder.engine.GameResult;
import nextstep.ladder.engine.Height;
import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.LadderRails;
import nextstep.ladder.engine.Line;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.LadderPointGenerateStrategy;
import nextstep.ladder.engine.Prizes;
import nextstep.ladder.engine.RailCount;

public class Step4Ladder extends FirstClassList<Line> implements Ladder {
    private final LadderRails ladderRails;

    private Step4Ladder(final List<Line> lines, final LadderRails ladderRails) {
        super(lines);
        this.ladderRails = ladderRails;
    }

    public static Step4Ladder of(final LadderRails ladderRails, final Height ladderHeight, LadderPointGenerateStrategy strategy) {
        if (ladderRails == null || ladderHeight == null) {
            throw new IllegalArgumentException("rail count or height cannot be null");
        }

        // todo lambda style
        List<Line> lines = IntStream.range(0, ladderHeight.toInt())
                .mapToObj(index -> LadderLine.init(ladderRails.railCount(), strategy))
                .collect(Collectors.toList());
        return new Step4Ladder(lines, ladderRails);
    }

    public static Step4Ladder of(final Step4LadderRails step4LadderFrame, final int height, final LadderPointGenerateStrategy strategy) {
        return of(step4LadderFrame, LadderHeight.of(height), strategy);
    }

    public GameResult move(Prizes prizes) {
        List<Integer> indexes = IntStream.range(0, ladderRails.railCount().toInt())
                .mapToObj(this::downToResult)
                .collect(Collectors.toList());

        return LadderGameResult.of(ladderRails, indexes);
    }

    @Override
    public Players players() {
        return ladderRails.players();
    }

    @Override
    public Prizes prizes() {
        return ladderRails.prizes();
    }

    @Override
    public RailCount railCount() {
        return ladderRails.railCount();
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
                "ladderFrame=" + ladderRails +
                '}';
    }
}
