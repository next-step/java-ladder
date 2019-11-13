package step2.domain;

import java.util.List;

public class PreDefinedBooleanGenerator implements BooleanGenerator {
    private final List<Boolean> booleans;
    private int index = 0;

    public PreDefinedBooleanGenerator(final List<Boolean> booleans) {
        this.booleans = booleans;
    }

    @Override
    public boolean next() {
        ensureNotExceedIndex();
        return booleans.get(index++);
    }

    private void ensureNotExceedIndex() {
        if (booleans.size() <= index) {
            this.index = 0;
        }
    }
}
