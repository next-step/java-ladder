package nextstep.ladder.domain;

public class Ladder {

    private final People people;
    private final Line line;

    public Ladder(String names) throws Exception {
        this.people = new People(names);
        line = new Line();
    }

    public People people() {
        return people;
    }

    public Line line() {
        return line;
    }
}
