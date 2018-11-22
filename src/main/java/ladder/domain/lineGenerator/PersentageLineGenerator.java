package ladder.domain.lineGenerator;

import ladder.domain.Line;
import ladder.domain.LineGenerator;
import ladder.domain.Point;

import java.util.Random;
import java.util.stream.IntStream;

public class PersentageLineGenerator implements LineGenerator {
    private static final Random random = new Random();

    private final int MAX_VALUE = 100;
    private final int DRAWING_RATE;

    public PersentageLineGenerator(int DRAWING_RATE) {
        this.DRAWING_RATE = DRAWING_RATE;
    }

    @Override
    public Line generator(int countOfPlayer) {
        Line line = new Line();
        
        line.addPoint(Point.of(false, generateWidthLine()));
        IntStream.range(1, countOfPlayer-1).forEach(i -> {
            boolean point = !line.canLastPointGotoRight() && generateWidthLine();
            line.addPoint(Point.of(line.canLastPointGotoRight(), point));
        });
        line.addPoint(Point.of(line.canLastPointGotoRight(), false));
        return line;
    }

    private boolean generateWidthLine() {
        if (random.nextInt(MAX_VALUE) <= DRAWING_RATE) {
            return true;
        }
        return false;
    }
}
