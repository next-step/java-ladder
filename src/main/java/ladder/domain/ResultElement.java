package ladder.domain;

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
}
