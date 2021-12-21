package nextstep.ladder.domain;

/**
 * @author han
 */
public class Ladder {
    private final Users users;
    private final Lines lines;
    private final Results results;

    private Ladder(Users users, Lines lines, Results results) {
        this.users = users;
        this.lines = lines;
        this.results = results;
    }

    public static Ladder from(Users users, Height height, Results results) {
        return new Ladder(users, Lines.of(users, height), results);
    }

    public Users getUsers() {
        return users;
    }

    public Lines getLines() {
        return lines;
    }

    public Results getResults() {
        return results;
    }
}
