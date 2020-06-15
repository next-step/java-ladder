package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private Random random = new Random();
    private List<Boolean> points = new ArrayList<>();

    public Line (int userCount) {
        IntStream.range(0, userCount-1)
                .mapToObj(index -> points.add(isAbleDrawLine(index)))
                .collect(Collectors.toList());
    }

    private boolean isAbleDrawLine(int idx) {
        if(idx == 0) return random.nextBoolean();
        return !points.get(idx - 1) && random.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
