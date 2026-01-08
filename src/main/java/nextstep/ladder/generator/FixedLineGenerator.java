package nextstep.ladder.generator;

import java.util.Arrays;
import java.util.Iterator;

public class FixedLineGenerator implements LineGenerator {
    private final Iterator<Boolean> points;

    public FixedLineGenerator(Boolean... points) {
        this.points = Arrays.asList(points).iterator();
    }

    @Override
    public boolean generate(boolean prev) {
        if(prev) return false;
        return points.next();
    }
}
