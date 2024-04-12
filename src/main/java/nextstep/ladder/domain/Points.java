package nextstep.ladder.domain;

import nextstep.ladder.utils.LadderGenerator;

import java.util.ArrayList;
import java.util.List;

public class Points {

    private final List<Boolean> points = new ArrayList<>();

    public Points(int countOfPerson, LadderGenerator strategy) {
        this(new CountOfPerson(countOfPerson), strategy);
    }

    public Points(CountOfPerson countOfPerson, LadderGenerator strategy) {
        countOfPerson.rangOfZeroToCount()
                .forEach(i -> {
            boolean hasLadder = strategy.generate();
            if (isNotFirstPoint(i) && hasLadderAtPrevious(i)) {
                hasLadder = false;
            }
            addLadderPoints(hasLadder);
        });
    }

    public void startGame(int i) {
        if (i == 0 && points.get(i)) {
            position++;
        }

        if (isNotFirstPoint(i) && points.get(i - 1)) {
            position--;
        }
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
