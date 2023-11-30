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

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(steps);
    }
}
