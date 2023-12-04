package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {

    private static final Random random = new Random();

    private final People people;


    public LadderFactory(String names) throws Exception {
        this.people = new People(names);
    }

    public Ladder ladder(int height) throws Exception {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; ++i) {
            lines.add(new Line(points()));
        }
        return new Ladder(lines);
    }

    public People people() {
        return this.people;
    }

    private Points points() {
        Points points = new Points(new ArrayList<>());
        for (int i = 0; i < people.count() - 1; ++i) {
            addLineRandomly(points);
        }
        return points;
    }

    private void addLineRandomly(Points points) {
        if (points.isEmpty()) {
            points.add(new Point(random.nextBoolean()));
            return;
        }
        if (points.isLastTrue()) {
            points.add(new Point(false));
            return;
        }
        if (points.isLastFalse()) {
            points.add(new Point(random.nextBoolean()));
        }
    }
}
