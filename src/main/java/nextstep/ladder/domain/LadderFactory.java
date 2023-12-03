package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.People;

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

    private List<Boolean> points() {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < people.count() - 1; ++i) {
            addLineRandomly(points);
        }
        return points;
    }

    private void addLineRandomly(List<Boolean> points) {
        if (points.isEmpty()) {
            points.add(random.nextBoolean());
        }
        if (points.get(points.size() - 1)) {
            points.add(false);
        }
        if (!points.get(points.size() - 1)) {
            points.add(random.nextBoolean());
        }
    }
}
