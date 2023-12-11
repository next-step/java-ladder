package ladder.gilbert.domain.data;

import java.util.Objects;

import static ladder.engine.Ladder.INDENT;

public class Goal {

    private final String value;

    public Goal(String value) {
        this.value = value;
    }

    public String formatted() {
        return INDENT.repeat(Name.NAME_SIZE + 1 - value.length()) + value;
    }

    @Override
    public String toString() {
        return value;
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
