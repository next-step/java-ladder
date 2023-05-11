package ladder.model.result;

public class LadderResult {

    private final String value;

    public LadderResult(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("input value must exist:" + value);
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

