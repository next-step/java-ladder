package nextstep.ladder.domain.generator;

import nextstep.ladder.domain.ladder.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LineGenerator {
    public static Line generateLine(int countOfPerson) {
        List<Boolean> line = new ArrayList<>();
        Point point = new Point(false, false);

        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean nextBoolean = randomBoolean();
            point = new Point(point.next(), nextBoolean);
            
            if (point.isConsecutive()) {
                nextBoolean = false;
                point = new Point(point.current(), false);
            }
            
            line.add(nextBoolean);
        }
        return new Line(line);
    }

    public static void assertValidLine(List<Boolean> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("사다리에는 빈값이 올 수 없습니다. values=" + values);
        }

        for(int i = 0; i < values.size() -1; i++) {
            Point point = new Point(values.get(i), values.get(i + 1));
            if(point.isConsecutive()) {
                throw new IllegalArgumentException("연속된 사다리 계단은 나올 수 없습니다.");
            }
        }
    }

    private static boolean randomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
