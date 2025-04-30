package nextstep.ladder.domain.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LineGenerator {
    public static List<Boolean> generateLine(int countOfPerson) {
        boolean lastBoolean = false;
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean currBoolean = randomBoolean();
            if(isConsecutiveLine(currBoolean, lastBoolean)) {
                currBoolean = false;
            }
            line.add(currBoolean);
            lastBoolean = currBoolean;
        }
        return line;
    }

    public static void assertValidLine(List<Boolean> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("사다리에는 빈값이 올 수 없습니다. values=" + values);
        }

        for(int i = 0; i < values.size() -1; i++) {
            if(isConsecutiveLine(values.get(i), values.get(i + 1))) {
                throw new IllegalArgumentException("연속된 사다리 계단은 나올 수 없습니다.");
            }
        }
    }

    private static boolean isConsecutiveLine(boolean curr, boolean last) {
        return curr && last;
    }

    private static boolean randomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
