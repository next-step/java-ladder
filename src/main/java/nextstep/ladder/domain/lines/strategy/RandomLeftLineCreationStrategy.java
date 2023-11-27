package nextstep.ladder.domain.lines.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import nextstep.ladder.domain.Line;

public class RandomLeftLineCreationStrategy implements LeftLineCreationStrategy {

    @Override
    public Line createLeftLine(Line beforLine, int height) {
        Random random = new Random();
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            if (beforLine.hasHorizontalLine(i)) {
                points.add(false);
                continue;
            }
            points.add(random.nextBoolean());
        }
        return new Line(points);
    }
}
