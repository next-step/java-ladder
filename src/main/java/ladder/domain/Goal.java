package ladder.domain;

import java.util.Objects;

public class Goal {

    private final String result;

    public Goal(String result) {

        this.result = result;
    }

    public String getResult() {

        return result;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal = (Goal) o;
        return Objects.equals(result, goal.result);
    }

    @Override
    public int hashCode() {

        return Objects.hash(result);
    }
}
