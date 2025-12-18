package nextstep.ladder.domain;


public class User {

    private final UserName name;
    private final NameLength length;

    public User(String name) {
        this.name = new UserName(name);
        this.length = new NameLength(name.length());
    }

    public UserName getName() {
        return name;
    }

    public NameLength getLength() {
        return length;
    }

}
