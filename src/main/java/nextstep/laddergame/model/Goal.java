package nextstep.laddergame.model;

import java.util.Objects;

public class Goal {

    private final String value;

    public Goal(String value) {
        this.value = value.trim();
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Goal goal = (Goal) o;
        return Objects.equals(value, goal.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
