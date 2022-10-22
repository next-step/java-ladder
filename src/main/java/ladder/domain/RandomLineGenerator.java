package ladder.domain;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomLineGenerator implements LineGenerator {
    @Override
    public Line create(int lineLength) {
        Line line = new Line(getRandomBoolean());
        IntStream.range(0, lineLength - 1)
                .forEach(i -> line.addPoint(generateNextPoint(line)));
        return line;
    }

    private boolean getRandomBoolean() {
        return new Random().nextBoolean();
    }

    private boolean generateNextPoint(Line line) {
        if (line.isLastPointTrue()) {
            return false;
        }
        return getRandomBoolean();
    }
}
