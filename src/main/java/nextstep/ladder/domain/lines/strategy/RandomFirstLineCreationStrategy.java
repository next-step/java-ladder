package nextstep.ladder.domain.lines.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import nextstep.ladder.domain.Line;

public class RandomFirstLineCreationStrategy implements FirstLineCreationStrategy {

    @Override
    public Line createFirstLine(int height) {
        Random random = new Random();
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            points.add(random.nextBoolean());
        }
        return new Line(points);
    }
}
