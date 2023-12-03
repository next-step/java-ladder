package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Boolean> steps;

    public Line(int space) {
        this.steps = new ArrayList<>();
        StepFactory stepFactory = new StepFactory();
        for (int i = 0; i < space; i++) {
            steps.add(stepFactory.next());
        }
    }

    public int following(int index) {
        if (index == 0) {
            return checkingAndGoingRight(index);
        }
        if (index == steps.size()) {
            return checkingAndGoingLeft(index);
        }
        return checkingBothDirections(index);
    }

    private int checkingAndGoingRight(int index) {
        if (steps.get(index)) {
            return goingRight(index);
        }
        return index;
    }

    private int checkingAndGoingLeft(int index) {
        if (steps.get(index - 1)) {
            return goingLeft(index);
        }
        return index;
    }

    private int checkingBothDirections(int index) {
        if (steps.get(index)) {
            return goingRight(index);
        }

        if (steps.get(index - 1)) {
            return goingLeft(index);
        }
        return index;
    }

    private int goingLeft(int index) {
        return index - 1;
    }

    private int goingRight(int index) {
        return index + 1;
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(steps);
    }
}
