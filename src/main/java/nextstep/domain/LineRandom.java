package nextstep.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineRandom implements LineCreateStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public List<Boolean> create(int count) {
        List<Boolean> line = new ArrayList<>();
        setLine(count, line);
        return line;
    }

    private void setLine(int count, List<Boolean> line) {
        line.add(RANDOM.nextBoolean());
        boolean beforePosition = line.get(0);
        for (int position = 1; position < count; position++) {
            boolean currentPosition = RANDOM.nextBoolean();

            if (beforePosition) {
                line.add(false);
                beforePosition = false;
                continue;
            }
            line.add(currentPosition);
            beforePosition = currentPosition;
        }
    }
}
