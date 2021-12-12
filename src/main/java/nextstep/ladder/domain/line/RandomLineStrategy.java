package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nextstep.ladder.domain.LineCount;

public class RandomLineStrategy implements LineGenerateStrategy {
    private static final Random random = new Random();

    @Override
    public List<Boolean> generate(LineCount lineCount) {
        List<Boolean> points = new ArrayList<>(lineCount.toInt());
        points.add(random.nextBoolean());
        for(int i = 1; i < lineCount.toInt(); i++) {
            if (points.get(i - 1)) {
                points.add(false);
            } else {
                points.add(random.nextBoolean());
            }
        }

        return points;
    }
}
