package step2.domain;

import java.util.concurrent.ThreadLocalRandom;

public class WidthAwareRandomBooleanGenerator implements BooleanGenerator {
    private final int width;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    private boolean before;
    private int index;

    public WidthAwareRandomBooleanGenerator(final int width) {
        this.width = width;
    }

    @Override
    public boolean next() {
        boolean now = random.nextBoolean();
        if (width != (index - 1) && before) {
            now = false;
        }
        before = now;
        index++;
        index %= width;
        return now;
    }
}
