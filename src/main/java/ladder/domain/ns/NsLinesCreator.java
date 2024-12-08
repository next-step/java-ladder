package ladder.domain.ns;

import ladder.domain.engine.Line;
import ladder.domain.engine.Lines;
import ladder.domain.engine.LinesCreator;
import ladder.domain.engine.Players;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NsLinesCreator implements LinesCreator {
    public static final int START_INCLUSIVE = 0;
    private final NsLineCreator nsLineCreator;

    public NsLinesCreator(NsLineCreator nsLineCreator) {
        this.nsLineCreator = nsLineCreator;
    }

    @Override
    public Lines create(Players players, int verticalSize) {
        List<Line> lines = IntStream.range(START_INCLUSIVE, verticalSize)
                .boxed()
                .map(index -> nsLineCreator.create(players.size()))
                .collect(Collectors.toUnmodifiableList());
        return new NsLines(lines);
    }
}
