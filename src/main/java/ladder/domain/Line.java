package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int personCount, Conditional conditional) {
        if (personCount < 2) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람 수가 너무 작습니다. 사람 수 : " + personCount);
        }
        makeLine(personCount - 1, conditional);
    }

    private void makeLine(int ladderWidth, Conditional conditional) {
        points.add(conditional.test());
        IntStream.range(1, ladderWidth)
                .forEach(i -> {
                    boolean randomLine = conditional.test();
                    if (points.get(i - 1)) {
                        randomLine = false;
                    }
                    points.add(randomLine);
                });
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
