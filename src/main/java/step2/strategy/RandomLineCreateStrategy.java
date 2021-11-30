package step2.strategy;

import step2.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class RandomLineCreateStrategy implements LineCreateStrategy {
    private static final int STEP_INIT_COUNT = 0;
    private static final int NUMBER_ONE = 1;

    @Override
    public List<Boolean> create(int count) {
        List<Boolean> line = new ArrayList<>();
        for (int step = STEP_INIT_COUNT; step < count - NUMBER_ONE; step++) {
            line.add(create(step, line));
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
