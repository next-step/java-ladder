package ladder.pattern;

import java.util.List;

public class CustomValueGenerator implements ValueGenerateStrategy {

    private int index = 0;
    private final List<Boolean> values;

    public CustomValueGenerator(List<Boolean> values) {
        this.values = values;
    }

    @Override
    public boolean booleanGenerate() {
        return values.get(index++);
    }
}
