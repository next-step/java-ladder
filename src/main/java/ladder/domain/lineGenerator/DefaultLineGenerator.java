package ladder.domain.lineGenerator;

import java.util.Random;
import java.util.stream.IntStream;

import ladder.domain.Line;
import ladder.domain.LineGenerator;
import ladder.domain.Point;

public class DefaultLineGenerator implements LineGenerator {
    private static final Random random = new Random();
    
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

    private static boolean generateWidthLine() {
        return random.nextBoolean();
    }
}
