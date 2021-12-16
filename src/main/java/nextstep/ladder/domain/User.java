package nextstep.ladder.domain;

/**
 * @author han
 */
public class User {

    private final Name name;

    public User(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name);
        return sb.toString();
    }
}
