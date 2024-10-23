package laddergame.v2.domain.generator;

import laddergame.v2.domain.Line;
import laddergame.v2.domain.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator implements LineGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public Line generate(int playerCount) {
        List<Position> positions = new ArrayList<>();

        Position current = Position.first(RANDOM.nextBoolean());
        positions.add(current);

        while (current.isInRange(playerCount)) {
            positions.add(current.next());
        }
        positions.add(current.last());
        return new Line(positions);
    }
}
