package nextstep.ladder.domain;

import nextstep.ladder.utils.LadderGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Points {

    private final List<Boolean> points = new ArrayList<>();

    public Points(int countOfPerson, LadderGenerator strategy) {
        IntStream.range(0, countOfPerson - 1).forEach(i -> {
            boolean hasLadder = strategy.generate();
            if (isNotFirstPoint(i) && hasLadderAtPrevious(i)) {
                hasLadder = false;
            }
            addLadderPoints(hasLadder);
        });
    }

    private boolean isNotFirstPoint(int i) {
        return i >= 1;
    }

    private Boolean hasLadderAtPrevious(int i) {
        return points.get(i - 1);
    }

    private void addLadderPoints(boolean hasLadder) {
        points.add(hasLadder);
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
