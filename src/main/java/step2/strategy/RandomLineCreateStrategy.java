package step2.strategy;

import step2.utils.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLineCreateStrategy implements LineCreateStrategy {
    private static final int STEP_INIT_COUNT = 0;
    private static final int NUMBER_ONE = 1;

    @Override
    public List<Boolean> create(int count) {
        List<Boolean> line = Stream.generate(() -> Boolean.FALSE)
                .limit(count).collect(Collectors.toList());
        for (int step = STEP_INIT_COUNT; step < count - NUMBER_ONE; step++) {
            line.set(step, create(step, line));
        }
        return line;
    }

    private boolean create(int step, List<Boolean> line) {
        if (step == STEP_INIT_COUNT) {
            return RandomUtil.nextBoolean();
        }
        return create(line);
    }

    private boolean create(List<Boolean> line) {
        boolean isNextLine = RandomUtil.nextBoolean();
        if (isConnected(line, isNextLine)) {
            return !isNextLine;
        }
        return isNextLine;
    }

    private boolean isConnected(List<Boolean> line, boolean isNextLine) {
        int lineSize = line.size() - NUMBER_ONE;
        return Boolean.logicalAnd(line.get(lineSize), isNextLine);
    }
}
