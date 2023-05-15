package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int MINIMUM_RANDOM_NUMBER = 0;

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson - 1)
                .forEach(this::addPoint);
    }

    private void addPoint(int index) {
        if (index == 0) {
            points.add(isRandomNumberMoreThanZero(RandomUtil.generator()));
            return;
        }
        if (!points.get(index - 1)) {
            points.add(isRandomNumberMoreThanZero(RandomUtil.generator()));
            return;
        }
        points.add(false);
    }

    private boolean isRandomNumberMoreThanZero(int randomNumber) {
        if (randomNumber > MINIMUM_RANDOM_NUMBER) return true;
        return false;
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
