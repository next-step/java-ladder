package nextstep.ladder.domain;

/**
 * @author han
 */
public class Ladder {
    private final Users users;
    private final Lines lines;

    private Ladder(Users users, Lines lines) {
        this.users = users;
        this.lines = lines;
    }

    public static Ladder from(Users users, Height height) {
        return new Ladder(users, Lines.of(users, height));
    }

    public Users getUsers() {
        return users;
    }

    public Lines getLines() {
        return lines;
    }
}
