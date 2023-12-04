package ladder.domain.data;

import java.util.Objects;

public class Goal {

    private final String value;

    public Goal(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Goal goal = (Goal) object;

        return Objects.equals(value, goal.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
