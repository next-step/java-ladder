package nextstep.ladder.factory;

import nextstep.ladder.domain.Line;
import nextstep.ladder.generator.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {
    private final LineGenerator generator;

    public LineFactory(LineGenerator generator) {
        this.generator = generator;
    }

    public Line create(int countOfPlayer) {
        List<Boolean> points = new ArrayList<>();
        boolean prev = false;

        for (int i=0; i<countOfPlayer-1; i++) {
            boolean current = generator.generate(prev);
            points.add(current);
            prev = current;
        }
        return new Line(points);
    }
}
