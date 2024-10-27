package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import ladder.strategy.LadderGenerateStrategy;

public class Line {
    private static final int START_RANGE_NUMBER = 0;

    private List<Boolean> points = new ArrayList<>();

    private Line(Users users, LadderGenerateStrategy ladderGenerateStrategy) {
        IntStream.range(START_RANGE_NUMBER, users.size())
                .forEach(point -> generateLadderLine(ladderGenerateStrategy));
    }

    public static Line of(Users users, LadderGenerateStrategy ladderGenerateStrategy) {
        return new Line(users, ladderGenerateStrategy);
    }

    private void generateLadderLine(LadderGenerateStrategy ladderGenerateStrategy) {
        if (hasLeftLadder() && ladderGenerateStrategy.ladderGenerate()) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    private boolean hasLeftLadder() {
        return !points.isEmpty() && !points.get(points.size() - 1);
    }

    private boolean hasLeftLadder(int index) {
        return !points.isEmpty() && !points.get(index - 1);
    }

    private boolean hasRightLadder(int index) {
        return index + 1 < points.size() && points.get(index + 1);
    }

    public int decideNextIndex(int index) {
        if (index != 0 && hasLeftLadder(index)) {
            return index - 1;
        }
        if (index != points.size() && hasRightLadder(index)) {
            return index + 1;
        }
        return index;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
