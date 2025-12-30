package nextstep.ladder.domain.user;


public class User {

    private final UserName name;

    public User(String name) {
        this.name = new UserName(name);
    }

    public UserName getName() {
        return name;
    }

    public String getNameValue() {
        return name.getName();
    }

}
