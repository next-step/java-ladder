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
}
