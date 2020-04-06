package ladder.domain.generator;

import ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {

    public RandomLineGenerator() { }

    @Override
    public List<Boolean> generate(int playerCount) {
        final List<Boolean> lines = init();
        for (int i = lines.size(); i < playerCount; i++) {
            boolean prevLine = lines.get(i - 1);
            lines.add(drawLine(prevLine));
        }
        return lines;
    }

    private List<Boolean> init() {
        return new ArrayList<>(Arrays.asList(Boolean.FALSE));
    }

    private Boolean drawLine(final boolean isExistPrev) {
        if (isExistPrev) {
            return Boolean.FALSE;
        }
        return RandomUtil.nextBoolean();
    }
}
