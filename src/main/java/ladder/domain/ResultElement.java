package ladder.domain;

import java.util.Objects;

public class ResultElement {
    private final String name;
    private final String goal;

    public ResultElement(String name, String goal) {
        this.name = name;
        this.goal = goal;
    }

    public String goal() {
        return goal;
    }

    public String name() {
        return name;
    }

    public boolean nameEquals(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultElement that = (ResultElement) o;
        return Objects.equals(name, that.name) && Objects.equals(goal, that.goal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, goal);
    }
}
