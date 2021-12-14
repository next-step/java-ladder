package nextstep.ladder.model;

public class Ladder {

    private final Players players;
    private final Lines lines;
    private final Results results;

    public Ladder(Person person, Lines lines, Results results) {
        this.person = person;
        this.lines = lines;
        this.results = results;
    }

    public String drawing() {
        return person.drawing() + "\n" +
                lines.drawing() + "\n" +
                results.drawing();
    }
}
