package nextstep.ladder.domain;

public class User {

    private final UserName name;

    public User(final String name) {
        this.name = new UserName(name);
    }

    public String name() {
        return name.getName();
    }
}
