package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final Person person;
    private final List<Step> steps;

    private Line(List<Step> steps) {
        this(steps, Person.of("empty"));
    }

    private Line(List<Step> steps, Person person) {
        this.steps = steps;
        this.person = person;
    }

    public static Line of(int height) {
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            steps.add(Step.of(i));
        }
        return new Line(steps);
    }

    public int getLineHeight() {
        return steps.size();
    }
}
