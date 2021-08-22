package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    public static final boolean FALSE_BECAUSE_OF_LEFT_TRUE = false;
    public static final int MIN_PERSON_COUNT = 2;
    private List<Boolean> points = new ArrayList<>();

    public Line(int personCount, LineGenerateStrategy lineGenerateStrategy) {
        validate(personCount);
        makeLine(personCount - 1, lineGenerateStrategy);
    }

    private void validate(int personCount) {
        if (personCount < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람 수가 너무 작습니다. 사람 수 : " + personCount);
        }
    }

    private void makeLine(int ladderWidth, LineGenerateStrategy lineGenerateStrategy) {
        points.add(lineGenerateStrategy.able());
        IntStream.range(1, ladderWidth)
                .forEach(i -> points.add(getRandomLine(i, lineGenerateStrategy)));
    }

    private Boolean getRandomLine(int i, LineGenerateStrategy lineGenerateStrategy) {
        if (points.get(i - 1)) {
            return FALSE_BECAUSE_OF_LEFT_TRUE;
        }
        return lineGenerateStrategy.able();
    }

    public boolean lineExists(int position) {
        return points.get(position);
    }

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }
}
