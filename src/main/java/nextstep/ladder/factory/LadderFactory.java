package nextstep.ladder.factory;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderFactory {
    private static final int ZERO = 0;

    public static Ladder createRandomLadder(int height, int countPerson) {
        List<Line> lines = new ArrayList<>();

        IntStream.range(ZERO, height)
                .forEach(i -> lines.add(Line.createLine(countPerson)));

        return new Ladder(lines);
    }
}
