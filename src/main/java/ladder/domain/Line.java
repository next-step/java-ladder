package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final boolean FALSE_BECAUSE_OF_LEFT_TRUE = false;
    private static final boolean OUT_OF_BOUND = false;
    private static final int MIN_WIDTH = 2;
    private List<Boolean> points = new ArrayList<>();

    public Line(int width, LineGenerateStrategy lineGenerateStrategy) {
        validate(width);
        points.add(lineGenerateStrategy.generatable());
        IntStream.range(1, width - 1)
                .forEach(position -> points.add(generatable(position, lineGenerateStrategy)));
    }

    private void validate(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람 수가 너무 작습니다. 사람 수 : " + width);
        }
    }

    private boolean generatable(int position, LineGenerateStrategy lineGenerateStrategy) {
        if (points.get(position - 1)) {
            return FALSE_BECAUSE_OF_LEFT_TRUE;
        }
        return lineGenerateStrategy.generatable();
    }

    public int move(int endIndex) {
        if (lineExists(endIndex - 1)) {
            return endIndex - 1;
        }
        if (lineExists(endIndex)) {
            return endIndex + 1;
        }
        return endIndex;
    }

    private boolean lineExists(int position) {
        if (position < 0 || position >= points.size()) {
            return OUT_OF_BOUND;
        }
        return points.get(position);
    }

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }

}
