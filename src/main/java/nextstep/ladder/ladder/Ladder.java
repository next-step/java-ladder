package nextstep.ladder.ladder;

import nextstep.ladder.ladder.dto.LadderResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;

    private final int width;
    private final List<LadderLine> lines;

    public Ladder(int width, List<LadderLine> lines) {
        this.width = width;
        this.lines = lines;
    }

    public static Ladder of(LadderBound bound) {
        int width = bound.getWidth();
        List<LadderLine> lines = IntStream.range(START_INDEX, bound.getHeight())
                .mapToObj(s -> LadderLine.of(width))
                .collect(Collectors.toList());

        return new Ladder(width, lines);
    }

    public LadderResult play() {
        LadderResult result = new LadderResult();
        IntStream.range(START_INDEX, width)
                .forEach(index -> result.put(index, getTarget(index)));
        return result;
    }

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private int getTarget(int position) {
        int target = position;
        for (LadderLine line : lines) {
            target = line.move(target);
        }

        return target;
    }
}
