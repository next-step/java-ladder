package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.strategy.LineCreateStrategy;
import nextstep.ladder.domain.user.LadderUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final int WIDTH = 5;
    private final List<Boolean> points = new ArrayList<>();

    public Line(LadderUsers ladderUsers, LineCreateStrategy lineCreateStrategy) {
        points.add(lineCreateStrategy.create(false));

        for (int i = 1; i < ladderUsers.getSize() - 1; i++) {
            boolean nextPoint = lineCreateStrategy.create(points.get(i - 1));
            points.add(nextPoint);
        }
    }

    @Override
    public String toString() {
        return points.stream()
            .map(point -> point ? "|" + "-".repeat(WIDTH) : "|" + " ".repeat(WIDTH))
            .collect(Collectors.joining("", "  ", "|"));
    }
}
