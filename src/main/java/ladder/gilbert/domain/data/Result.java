package ladder.gilbert.domain.data;

import java.util.Objects;

public class Result {

    private final Person person;
    private final Goal goal;

    public Result(Person person, Goal goal) {
        this.person = person;
        this.goal = goal;
    }

    public String formatted() {
        return person + " : " + goal;
    }

    @Override
    public String toString() {
        return goal.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Result result = (Result) object;

        if (!Objects.equals(person, result.person)) {
            return false;
        }
        return Objects.equals(goal, result.goal);
    }

    @Override
    public int hashCode() {
        int result = person != null ? person.hashCode() : 0;
        result = 31 * result + (goal != null ? goal.hashCode() : 0);
        return result;
    }
}
