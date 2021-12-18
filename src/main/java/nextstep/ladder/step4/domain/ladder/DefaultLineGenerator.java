package nextstep.ladder.step4.domain.ladder;

import static nextstep.ladder.step4.exception.LineMinimumLengthException.MINIMUM_LENGTH;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.step4.domain.ladder.engine.LineGenerator;
import nextstep.ladder.step4.domain.ladder.strategy.LineStrategy;
import nextstep.ladder.step4.exception.LineMinimumLengthException;

public class DefaultLineGenerator implements LineGenerator {

    private static final int FIRST_INDEX = 0;
    private static final int START_INDEX = 1;
    private static final int LAST_INDEX_OF_WIDTH = 1;

    private final LineStrategy lineStrategy;

    public DefaultLineGenerator(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    @Override
    public DefaultLine generate(int width) {
        valid(width);
        List<Point> line = new ArrayList<>();

        Direction direction = Direction.first(lineStrategy.isLine());
        line.add(new Point(FIRST_INDEX, direction));

        final int lastIndex = width - LAST_INDEX_OF_WIDTH;
        for (int index = START_INDEX; index < lastIndex; index++) {
            direction = direction.next(lineStrategy.isLine());
            line.add(new Point(index, direction));
        }

        line.add(new Point(lastIndex, direction.last()));
        return new DefaultLine(line);
    }

    private void valid(int width) {
        if (width < MINIMUM_LENGTH) {
            throw new LineMinimumLengthException();
        }
    }

}
