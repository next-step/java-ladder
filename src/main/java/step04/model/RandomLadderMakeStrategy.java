package step04.model;

import java.util.Optional;
import java.util.Random;

public class RandomLadderMakeStrategy implements LadderMakeStrategy {
    private static final Random random = new Random();

    @Override
    public Point makePoint(Point previousPoint) {
        return Optional.ofNullable(previousPoint)
                .filter(point -> point == Point.ROW)
                .map(point -> Point.BLANK)
                .orElse(random.nextBoolean() ? Point.ROW : Point.BLANK);
    }
}
