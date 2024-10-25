package ladder2;

import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {
    @Override
    public Line generate(int playerCount) {
        List<Position> positions = new ArrayList<>();
        NextGenerator randomGenerator = new NextGenerator();

        Position current = Position.first(randomGenerator.nextBoolean());
        positions.add(current);

        while (current.checkRange(playerCount)) {
            positions.add(current.next());
        }

        positions.add(current.last());
        return new Line(positions);
    }
}
