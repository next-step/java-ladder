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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(users);
        sb.append("\n");
        sb.append(lines);
        return sb.toString();
    }
}
