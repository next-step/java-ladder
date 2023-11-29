package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private List<Boolean> steps;

    public Line(int space) {
        this.steps = new ArrayList<>();
        Step step = new Step();
        for (int i = 0; i < space; i++) {
            steps.add(step.next());
        }
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(steps);
    }
}
