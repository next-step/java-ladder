package nextstep.ladder.factory;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderCreator {

    private final LineCreator lineCreator;

    public LadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    public Ladder create(int count, int height, String... result) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineCreator.create(count));
        }
        return new Ladder(lines, Arrays.stream(result).collect(Collectors.toList()));
    }
}
