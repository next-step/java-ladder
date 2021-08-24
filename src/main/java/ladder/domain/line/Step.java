package ladder.domain.line;

import java.util.Objects;

public class Step {

    private final boolean value;

    private Step(boolean value) {
        this.value = value;
    }

    public static Step valueOf(boolean value) {
        return new Step(value);
    }

    public boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return value == step.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
