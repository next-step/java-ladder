package nextstep.ladder.domain;

/**
 * @author han
 */
public class User {

    private final Name name;

    public User(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
